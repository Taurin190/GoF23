import org.junit.Test;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class HTMLBuilderTest {
    @Test
    public void testGetResult() throws Exception {
        HTMLBuilder builder = new HTMLBuilder();
        builder.makeTitle("Hello");
        String actual = builder.getResult();
        assertEquals("Hello.html", actual);
    }
    @Test
    public void testMakeTitle() throws Exception {
        HTMLBuilder builder = new HTMLBuilder();
        builder.makeTitle("Hello");
        String filename = builder.getResult();
        Path file = Paths.get(filename);
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String actual = br.readLine();
            assertEquals("<html><head><title>Hello</title></head><body>\n", actual);
            actual = br.readLine();
            assertEquals("<h1>Hello</h1>\n", actual);
        }
    }
    @Test
    public void testMakeString() throws Exception {
        HTMLBuilder builder = new HTMLBuilder();
        builder.makeTitle("Hello");
        builder.makeString("World");
        String filename = builder.getResult();
        Path file = Paths.get(filename);
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String actual = br.readLine();
            assertEquals("<html><head><title>Hello</title></head><body>\n", actual);
            actual = br.readLine();
            assertEquals("<h1>Hello</h1>\n", actual);
            actual = br.readLine();
            assertEquals("<p>World</p>\n", actual);
        }
    }
    @Test
    public void testMakeItems() throws Exception {
        HTMLBuilder builder = new HTMLBuilder();
        builder.makeTitle("Hello");
        builder.makeItems(new String[]{"HogeHoge", "FugaFuga"});
        String filename = builder.getResult();
        Path file = Paths.get(filename);
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String actual = br.readLine();
            assertEquals("<html><head><title>Hello</title></head><body>\n", actual);
            actual = br.readLine();
            assertEquals("<h1>Hello</h1>\n", actual);
            actual = br.readLine();
            assertEquals("<ul>\n", actual);
            actual = br.readLine();
            assertEquals("<li>HogeHoge</li>\n", actual);
            actual = br.readLine();
            assertEquals("<li>FugaFuga</li>\n", actual);
            actual = br.readLine();
            assertEquals("</ul>\n", actual);
        }
    }
    @Test
    public void testMakeClose() throws Exception {
        HTMLBuilder builder = new HTMLBuilder();
        builder.makeTitle("Hello");
        builder.close();
        String filename = builder.getResult();
        Path file = Paths.get(filename);
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String actual = br.readLine();
            assertEquals("<html><head><title>Hello</title></head><body>\n", actual);
            actual = br.readLine();
            assertEquals("<h1>Hello</h1>\n", actual);
            actual = br.readLine();
            assertEquals("</body></html>\n", actual);
        }
    }
}
