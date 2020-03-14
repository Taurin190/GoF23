import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class DigitObserverTest {
    private PrintStream defaultPrintStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    @Mock
    NumberGenerator generator;
    @Before
    public void setup() {
        defaultPrintStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testUpdate() {
        DigitObserver digitObserver = new DigitObserver();
        when(generator.getNumber()).thenReturn(10);
        digitObserver.update(generator);
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("DigitObserver: 10\n", actual);
    }
}
