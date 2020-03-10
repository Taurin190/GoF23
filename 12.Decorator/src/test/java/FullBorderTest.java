import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class FullBorderTest {
    @Mock
    private Display display;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetColumns() {
        FullBorder fullBorder = new FullBorder(display);
        when(display.getColumns()).thenReturn(4);
        int actual = fullBorder.getColumns();
        assertEquals(6, actual);
    }
    @Test
    public void testGetRows() {
        FullBorder fullBorder = new FullBorder(display);
        when(display.getRows()).thenReturn(1);
        int actual = fullBorder.getRows();
        assertEquals(3, actual);
    }
    @Test
    public void testGetRowText() {
        FullBorder fullBorder = new FullBorder(display);
        when(display.getRowText(0)).thenReturn("test");
        when(display.getColumns()).thenReturn(4);
        when(display.getRows()).thenReturn(1);
        String actual = fullBorder.getRowText(0);
        assertEquals("+----+", actual);
        actual = fullBorder.getRowText(1);
        assertEquals("|test|", actual);
        actual = fullBorder.getRowText(2);
        assertEquals("+----+", actual);
    }
}
