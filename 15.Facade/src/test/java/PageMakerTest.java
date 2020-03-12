import org.junit.After;
import org.junit.Test;
import org.mockito.Mock;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class PageMakerTest {
    @Test
    public void testMakeWelcomePage() {
        PageMaker.makeWelcomePage("test_addr@mail.com", "test_output.html");
        Path file = Paths.get("test_output.html");
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String actual = br.readLine();
            assertEquals("<html>", actual);
            actual = br.readLine();
            assertEquals("<head>", actual);
            actual = br.readLine();
            assertEquals("<title>Welcome to Ms.Test's page!</title>", actual);
            actual = br.readLine();
            assertEquals("</head>", actual);
            actual = br.readLine();
            assertEquals("<body>", actual);
            actual = br.readLine();
            assertEquals("<h1>Welcome to Ms.Test's page!</h1>", actual);
            actual = br.readLine();
            assertEquals("<p>Ms.Testのページへようこそ。</p>", actual);
            actual = br.readLine();
            assertEquals("<p>メール待っていますね。</p>", actual);
            actual = br.readLine();
            assertEquals("<a href=\"mailto:test_addr@mail.com\">Ms.Test</a>", actual);
            actual = br.readLine();
            assertEquals("</body>", actual);
            actual = br.readLine();
            assertEquals("</html>", actual);
        } catch (IOException e) {
            fail();
        }
    }
    @After
    public void teardown() {
        File file = new File("test_output.html");
        if (file.exists()) {
            file.delete();
        }
    }
}
