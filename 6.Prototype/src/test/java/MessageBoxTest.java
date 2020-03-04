import org.junit.Before;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MessageBoxTest {
    private PrintStream defaultPrintStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    @Before
    public void setup() {
        defaultPrintStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
    }
    @Test
    public void useTest() throws Exception {
        MessageBox messageBox = new MessageBox('*');
        messageBox.use("Hello");
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("*********\n* Hello *\n*********\n", actual);
    }
    @Test
    public void createCloneTest() {
        MessageBox messageBox = new MessageBox('*');
        MessageBox clonedMessageBox = (MessageBox) messageBox.createClone();
        assertTrue(clonedMessageBox instanceof MessageBox);
        assertNotEquals(messageBox, clonedMessageBox);
    }
}
