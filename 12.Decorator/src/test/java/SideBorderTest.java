import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class SideBorderTest {
    @Mock
    private Display display;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testGetColumns() {
        SideBorder sideBorder = new SideBorder(display,'|');
        when(display.getColumns()).thenReturn(4);
        int actual = sideBorder.getColumns();
        assertEquals(6, actual);
    }
    @Test
    public void testGetRows() {
        SideBorder sideBorder = new SideBorder(display,'|');
        when(display.getRows()).thenReturn(1);
        int actual = sideBorder.getRows();
        assertEquals(1, actual);
    }
    @Test
    public void testGetRowText() {
        SideBorder sideBorder = new SideBorder(display,'|');
        when(display.getRowText(0)).thenReturn("test");
        String actual = sideBorder.getRowText(0);
        assertEquals("|test|", actual);
    }
}
