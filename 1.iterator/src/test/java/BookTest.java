import static org.junit.Assert.*;
import org.junit.Test;

public class BookTest {
    @Test
    public void testName() throws Exception {
        Book book = new Book("test");
        assertEquals("test", book.getName());
    }
}
