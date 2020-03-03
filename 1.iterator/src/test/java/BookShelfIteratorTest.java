import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BookShelfIteratorTest {
    @Mock
    private BookShelf bookShelfMock;
    @Mock
    private Book bookMock;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testHasNext() throws Exception {
        when(bookShelfMock.getLength()).thenReturn(1);
        BookShelfIterator iterator = new BookShelfIterator(bookShelfMock);
        assertTrue(iterator.hasNext());
    }
    @Test
    public void testNext() throws Exception {
        when(bookMock.getName()).thenReturn("test book mock");
        when(bookShelfMock.getBookAt(0)).thenReturn(bookMock);
        BookShelfIterator iterator = new BookShelfIterator(bookShelfMock);
        Book actual = (Book) iterator.next();
        assertEquals("test book mock", actual.getName());
    }
    @Test
    public void testHasNextAfterNext() throws Exception {
        when(bookShelfMock.getLength()).thenReturn(1);
        when(bookMock.getName()).thenReturn("test book mock");
        when(bookShelfMock.getBookAt(0)).thenReturn(bookMock);
        BookShelfIterator iterator = new BookShelfIterator(bookShelfMock);
        assertTrue(iterator.hasNext());
        Book actual = (Book) iterator.next();
        assertEquals("test book mock", actual.getName());
        assertFalse(iterator.hasNext());
    }
}
