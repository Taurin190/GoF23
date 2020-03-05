import org.junit.Before;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class StringDisplayTest {
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
        StringDisplay stringDisplay = new StringDisplay("Hello World");
        stringDisplay.open();
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("+-----------+\n", actual);
    }
    @Test
    public void testPrint() throws Exception {
        StringDisplay stringDisplay = new StringDisplay("Hello World");
        stringDisplay.print();
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("|Hello World|\n", actual);
    }
    @Test
    public void testClose() throws Exception {
        StringDisplay stringDisplay = new StringDisplay("Hello World");
        stringDisplay.close();
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("+-----------+\n", actual);
    }
    @Test
    public void testDisplay() throws Exception {
        StringDisplay stringDisplay = new StringDisplay("Hello World");
        stringDisplay.display();
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals(
                "+-----------+\n" +
                "|Hello World|\n" +
                "|Hello World|\n" +
                "|Hello World|\n" +
                "|Hello World|\n" +
                "|Hello World|\n" +
                "+-----------+\n", actual);
    }
}
