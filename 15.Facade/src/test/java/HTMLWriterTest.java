import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.io.Writer;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class HtmlWriterTest {
    @Mock
    private Writer writer;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testTitle() {
        HtmlWriter htmlWriter = new HtmlWriter(writer);
        try {
            htmlWriter.title("test");
            verify(writer, times(1)).write("<html>\n");
            verify(writer, times(1)).write("<head>\n");
            verify(writer, times(1)).write("<title>test</title>\n");
            verify(writer, times(1)).write("</head>\n");
            verify(writer, times(1)).write("<body>\n");
            verify(writer, times(1)).write("<h1>test</h1>\n");
        } catch (IOException e) {
            fail();
        }
    }
    @Test
    public void testParagraph() {
        HtmlWriter htmlWriter = new HtmlWriter(writer);
        try {
            htmlWriter.paragraph("test");
            verify(writer, times(1)).write("<p>test</p>\n");
        } catch (IOException e) {
            fail();
        }
    }
    @Test
    public void testLink() {
        HtmlWriter htmlWriter = new HtmlWriter(writer);
        try {
            htmlWriter.link("http://test.com", "test");
            verify(writer, times(1)).write("<a href=\"http://test.com\">test</a>\n");
        } catch (IOException e) {
            fail();
        }
    }
    @Test
    public void testMailto() {
        HtmlWriter htmlWriter = new HtmlWriter(writer);
        try {
            htmlWriter.mailto("test@example.com", "Mr.test");
            verify(writer, times(1)).write("<a href=\"mailto:test@example.com\">Mr.test</a>\n");
        } catch (IOException e) {
            fail();
        }
    }
    @Test
    public void testClose() {
        HtmlWriter htmlWriter = new HtmlWriter(writer);
        try {
            htmlWriter.close();
            verify(writer, times(1)).write("</body>\n");
            verify(writer, times(1)).write("</html>\n");
            verify(writer, times(1)).close();
        } catch (IOException e) {
            fail();
        }
    }
}
