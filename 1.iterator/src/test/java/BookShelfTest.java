import static org.junit.Assert.*;
import org.junit.Test;

public class BookShelfTest {
    @Test
    public void testBookShelf() throws Exception {
        BookShelf bookShelf = new BookShelf();
        Book book1 = new Book("test1");
        Book book2 = new Book("test2");
        Book book3 = new Book("test3");
        bookShelf.appendBook(book1);
        bookShelf.appendBook(book2);
        bookShelf.appendBook(book3);

        assertEquals(3, bookShelf.getLength());
        assertEquals("test1", bookShelf.getBookAt(0).getName());
    }
}
