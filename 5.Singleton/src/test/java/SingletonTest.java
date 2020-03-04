import org.junit.Before;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SingletonTest {
    private PrintStream defaultPrintStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    @Before
    public void setup() {
        defaultPrintStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
    }
    @Test
    public void getInstanceTest() {
        Singleton singleton = Singleton.getInstance();
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("インスタンスを生成しました。\n", actual);
        assertTrue(singleton instanceof Singleton);
    }
}
