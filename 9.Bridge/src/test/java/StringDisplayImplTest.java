import org.junit.Before;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class StringDisplayImplTest {
    private PrintStream defaultPrintStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    @Before
    public void setup() {
        defaultPrintStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
    }
    @Test
    public void testRawOpen() throws Exception {
        StringDisplayImpl stringDisplay = new StringDisplayImpl("Hello World.");
        stringDisplay.rawOpen();
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("+------------+\n", actual);
    }
    @Test
    public void testRawPrint() throws Exception {
        StringDisplayImpl stringDisplay = new StringDisplayImpl("Hello World.");
        stringDisplay.rawPrint();
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("|Hello World.|\n", actual);
    }
    @Test
    public void testRawClose() throws Exception {
        StringDisplayImpl stringDisplay = new StringDisplayImpl("Hello World.");
        stringDisplay.rawClose();
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("+------------+\n", actual);
    }
}
