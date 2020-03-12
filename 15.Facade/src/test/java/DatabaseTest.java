import org.junit.Before;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    private PrintStream defaultPrintStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    @Before
    public void setup() {
        defaultPrintStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
    }
    @Test
    public void testGetProperties() {
        Properties properties = Database.getProperties("database");
        String actual2 = properties.getProperty("test");
        assertEquals("ok", actual2);
    }
    @Test
    public void testGetPropertiesWithInvalidFilename() {
        Properties properties = Database.getProperties("invalid");
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("Warning: invalid.txt is not found.\n", actual);
    }
}
