import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PrintBannerTest {
    private PrintStream defaultPrintStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    @Before
    public void setup() {
        defaultPrintStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
    }
    @Test
    public void testPrintWeak() throws Exception {
        PrintBanner printBanner = new PrintBanner("Hello world");
        printBanner.printWeak();
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("(Hello world)" + System.lineSeparator(), actual);
    }
    @Test
    public void testPrintStrong() throws Exception {
        PrintBanner printBanner = new PrintBanner("Hello world");
        printBanner.printStrong();
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("*Hello world*" + System.lineSeparator(), actual);
    }
    @After
    public void tearDown() {
        System.setOut(defaultPrintStream);
    }
}
