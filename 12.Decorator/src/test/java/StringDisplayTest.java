import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringDisplayTest {
    @Test
    public void testGetColumns() {
        StringDisplay stringDisplay = new StringDisplay("test");
        int actual = stringDisplay.getColumns();
        assertEquals(4, actual);
    }
    @Test
    public void testGetRows() {
        StringDisplay stringDisplay = new StringDisplay("test");
        int actual = stringDisplay.getRows();
        assertEquals(1, actual);
    }
    @Test
    public void testGetRowText() {
        StringDisplay stringDisplay = new StringDisplay("test");
        String actual = stringDisplay.getRowText(0);
        assertEquals("test", actual);
        actual = stringDisplay.getRowText(1);
        assertEquals(null, actual);
    }
}
