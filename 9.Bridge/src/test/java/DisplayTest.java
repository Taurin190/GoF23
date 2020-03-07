import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DisplayTest {
    @Mock
    private DisplayImpl displayImplMock;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testOpen() throws Exception {
        Display display = new Display(displayImplMock);
        display.open();
        verify(displayImplMock, times(1)).rawOpen();
    }
    @Test
    public void testPrint() throws Exception {
        Display display = new Display(displayImplMock);
        display.print();
        verify(displayImplMock, times(1)).rawPrint();
    }
    @Test
    public void testCloses() {
        Display display = new Display(displayImplMock);
        display.close();
        verify(displayImplMock, times(1)).rawClose();
    }
    @Test
    public void testDisplay() {
        Display display = new Display(displayImplMock);
        display.display();
        verify(displayImplMock, times(1)).rawOpen();
        verify(displayImplMock, times(1)).rawPrint();
        verify(displayImplMock, times(1)).rawOpen();
    }
}
