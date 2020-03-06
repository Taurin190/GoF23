import org.junit.After;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class HTMLBuilderTest {
    private String title = "Hello";
    @Test
    public void testGetResult() throws Exception {
        HTMLBuilder builder = new HTMLBuilder();
        builder.makeTitle(title);
        String actual = builder.getResult();
        assertEquals("Hello.html", actual);
    }
    @Test
    public void testMakeTitle() throws Exception {
        HTMLBuilder builder = new HTMLBuilder();
        builder.makeTitle(title);
        String filename = builder.getResult();
        Path file = Paths.get(filename);
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String actual = br.readLine();
            assertEquals("<html><head><title>Hello</title></head><body>", actual);
            actual = br.readLine();
            assertEquals("<h1>Hello</h1>", actual);
        }
    }
    @Test
    public void testMakeString() throws Exception {
        HTMLBuilder builder = new HTMLBuilder();
        builder.makeTitle(title);
        builder.makeString("World");
        String filename = builder.getResult();
        Path file = Paths.get(filename);
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String actual = br.readLine();
            assertEquals("<html><head><title>Hello</title></head><body>", actual);
            actual = br.readLine();
            assertEquals("<h1>Hello</h1>", actual);
            actual = br.readLine();
            assertEquals("<p>World</p>", actual);
        }
    }
    @Test
    public void testMakeItems() throws Exception {
        HTMLBuilder builder = new HTMLBuilder();
        builder.makeTitle(title);
        builder.makeItems(new String[]{"HogeHoge", "FugaFuga"});
        String filename = builder.getResult();
        Path file = Paths.get(filename);
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String actual = br.readLine();
            assertEquals("<html><head><title>Hello</title></head><body>", actual);
            actual = br.readLine();
            assertEquals("<h1>Hello</h1>", actual);
            actual = br.readLine();
            assertEquals("<ul>", actual);
            actual = br.readLine();
            assertEquals("<li>HogeHoge</li>", actual);
            actual = br.readLine();
            assertEquals("<li>FugaFuga</li>", actual);
            actual = br.readLine();
            assertEquals("</ul>", actual);
        }
    }
    @Test
    public void testMakeClose() throws Exception {
        HTMLBuilder builder = new HTMLBuilder();
        builder.makeTitle(title);
        builder.close();
        String filename = builder.getResult();
        Path file = Paths.get(filename);
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String actual = br.readLine();
            assertEquals("<html><head><title>Hello</title></head><body>", actual);
            actual = br.readLine();
            assertEquals("<h1>Hello</h1>", actual);
            actual = br.readLine();
            assertEquals("</body></html>", actual);
        }
    }
    @After
    public void teardown() {
        File file = new File(title + ".html");
        if (file.exists()) {
            file.delete();
        }
    }
}
