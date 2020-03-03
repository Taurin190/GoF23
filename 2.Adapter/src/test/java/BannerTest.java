import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BannerTest {
    private PrintStream defaultPrintStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    @Before
    public void setup() {
        defaultPrintStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
    }
    @Test
    public void testShowWithParen() throws Exception {
        Banner banner = new Banner("Hello world");
        banner.showWithParen();
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("(Hello world)" + System.lineSeparator(), actual);
    }
    @Test
    public void testShowWithAster() throws Exception {
        Banner banner = new Banner("Hello world");
        banner.showWithAster();
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("*Hello world*" + System.lineSeparator(), actual);
    }
    @After
    public void tearDown() {
        System.setOut(defaultPrintStream);
    }
}
