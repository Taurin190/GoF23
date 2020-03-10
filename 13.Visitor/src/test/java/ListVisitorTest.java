import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ListVisitorTest {
    private PrintStream defaultPrintStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    @Mock
    private File file;
    @Mock
    private Directory directory;
    @Before
    public void setup() {
        defaultPrintStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testFileVisit() {
        ListVisitor listVisitor = new ListVisitor();
        when(file.toString()).thenReturn("testFile (10)");
        listVisitor.visit(file);
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("/testFile (10)\n", actual);
    }
    @Test
    public void testDirectoryVisit() {
        ListVisitor listVisitor = new ListVisitor();
        when(directory.toString()).thenReturn("testDirectory (10)");
        listVisitor.visit(directory);
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("/testDirectory (10)\n", actual);
    }
}
