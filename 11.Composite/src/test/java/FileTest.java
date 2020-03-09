import org.junit.Before;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FileTest {
    private PrintStream defaultPrintStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    @Before
    public void setup() {
        defaultPrintStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
    }
    @Test
    public void testGetName() throws Exception{
        File file = new File("TestFile", 10);
        String actual = file.getName();
        assertEquals("TestFile", actual);
    }
    @Test
    public void testGetSize() throws Exception{
        File file = new File("TestFile", 10);
        int actual = file.getSize();
        assertEquals(10, actual);
    }
    @Test
    public void testPrintList() throws Exception{
        File file = new File("TestFile", 10);
        file.printList("hello");
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("hello/TestFile (10)\n", actual);
    }
    @Test
    public void testFileTreatmentExceptionWithAdd() {
        File file = new File("TestFile", 10);
        try {
            file.add(new File("TestFile2", 20));
            fail();
        } catch (FileTreatmentException e) {
            assertEquals(null, e.getMessage());
        }
    }
}
