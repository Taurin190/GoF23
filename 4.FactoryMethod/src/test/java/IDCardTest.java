import org.junit.Before;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class IDCardTest {
    private PrintStream defaultPrintStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    @Before
    public void setup() {
        defaultPrintStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
    }
    @Test
    public void testUse() {
        IDCard idCard = new IDCard("test");
        idCard.use();
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("testのカードを作ります。\ntestのカードを使います。\n", actual);
    }
    @Test
    public void testGetOwner() {
        IDCard idCard = new IDCard("test");
        String actual = idCard.getOwner();
        assertEquals("test", actual);
    }
}
