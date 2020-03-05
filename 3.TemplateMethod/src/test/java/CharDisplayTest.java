import org.junit.Before;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CharDisplayTest {
    private PrintStream defaultPrintStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    @Before
    public void setup() {
        defaultPrintStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
    }
    @Test
    public void testOpen() throws Exception {
        CharDisplay charDisplay = new CharDisplay("A");
        charDisplay.open();
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("<<", actual);
    }
    @Test
    public void testPrint() throws Exception {
        CharDisplay charDisplay = new CharDisplay("A");
        charDisplay.print();
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("A", actual);
    }
    @Test
    public void testClose() throws Exception {
        CharDisplay charDisplay = new CharDisplay("A");
        charDisplay.close();
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals(">>\n", actual);
    }
    @Test
    public void testDisplay() throws Exception {
        CharDisplay charDisplay = new CharDisplay("A");
        charDisplay.display();
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("<<AAAAA>>\n", actual);
    }
}
