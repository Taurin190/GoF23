import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class FileTest {
    private PrintStream defaultPrintStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    @Mock
    private Visitor visitor;
    @Before
    public void setup() {
        defaultPrintStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
        MockitoAnnotations.initMocks(this);
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
    @Test
    public void testAccept() {
        File file = new File("TestFile", 10);
        file.accept(visitor);
        verify(visitor, times(1)).visit(file);
    }
}
