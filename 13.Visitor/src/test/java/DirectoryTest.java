import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DirectoryTest {
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
        Directory directory = new Directory("TestDirectory");
        String actual = directory.getName();
        assertEquals("TestDirectory", actual);
    }
    @Test
    public void testGetSize() throws Exception{
        Directory directory = new Directory("TestDirectory");
        int actual = directory.getSize();
        assertEquals(0, actual);
    }
    @Test
    public void testAdd() throws Exception{
        Directory directory = new Directory("TestDirectory");
        Entry actual = directory.add(new File("test1", 10));
        assertEquals("test1", actual.getName());
        assertEquals(10, actual.getSize());
    }
    @Test
    public void testGetSizeAfterAdd() throws Exception{
        Directory directory = getTestDirectory();
        assertEquals(60, directory.getSize());
    }
    @Test
    public void testPrintList() throws Exception{
        Directory directory = new Directory("TestDirectory");
        directory.printList("hello");
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("hello/TestDirectory (0)\n", actual);
    }
    @Test
    public void testPrintListWithSeveralFiles() throws Exception{
        Directory directory = getTestDirectory();
        directory.printList("hello");
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("hello/TestDirectory (60)\nhello/TestDirectory/test1 (10)\n" +
                "hello/TestDirectory/test2 (20)\nhello/TestDirectory/test3 (30)\n", actual);
    }
    private Directory getTestDirectory() {
        Directory directory = new Directory("TestDirectory");
        directory.add(new File("test1", 10));
        directory.add(new File("test2", 20));
        directory.add(new File("test3", 30));
        return directory;
    }
    @Test
    public void testAccept() {
        Directory directory = new Directory("TestDirectory");
        directory.accept(visitor);
        verify(visitor, times(1)).visit(directory);
    }
}
