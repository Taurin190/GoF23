import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CountDisplayTest {
    @Mock
    DisplayImpl displayImplMock;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testMultipleDisplay() {
        CountDisplay countDisplay = new CountDisplay(displayImplMock);
        countDisplay.multipleDisplay(10);
        verify(displayImplMock, times(1)).rawOpen();
        verify(displayImplMock, times(10)).rawPrint();
        verify(displayImplMock, times(1)).rawClose();
    }
}
