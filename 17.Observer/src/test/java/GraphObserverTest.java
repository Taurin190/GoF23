import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class GraphObserverTest {
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
        GraphObserver graphObserver = new GraphObserver();
        when(generator.getNumber()).thenReturn(10);
        graphObserver.update(generator);
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("GraphObserver: **********\n", actual);
    }
}
