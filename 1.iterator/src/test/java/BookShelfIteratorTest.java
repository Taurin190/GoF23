import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BookShelfIteratorTest {
    @Mock
    private BookShelf bookShelfMock;
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
}
