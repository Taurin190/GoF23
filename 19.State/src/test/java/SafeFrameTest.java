import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.awt.event.ActionEvent;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SafeFrameTest {
    private PrintStream defaultPrintStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    @Mock
    private State state;
    @Before
    public void setup() {
        defaultPrintStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testChangeState() {
        SafeFrame safeFrame = new SafeFrame("テスト");
        when(state.toString()).thenReturn("[テスト]");
        safeFrame.changeState(state);
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("[昼間]から[テスト]へ状態が変化しました。\n", actual);
    }
    @Test
    public void testSetClock() {
        SafeFrame safeFrame = new SafeFrame("テスト");
        when(state.toString()).thenReturn("[テスト]");
        safeFrame.changeState(state);

        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
        safeFrame.setClock(7);
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("現在時刻は07:00\n", actual);
        verify(state, times(1)).doClock(safeFrame, 7);

        safeFrame.changeState(state);
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
        safeFrame.setClock(12);
        System.out.flush();
        actual = byteArrayOutputStream.toString();
        assertEquals("現在時刻は12:00\n", actual);
        verify(state, times(1)).doClock(safeFrame, 12);
    }
}
