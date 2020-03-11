import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

public class SpecialSupportTest {
    @Mock
    private Trouble trouble;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testResolveWithOdd() {
        SpecialSupport specialSupport = new SpecialSupport("test", 100);
        when(trouble.getNumber()).thenReturn(100);
        boolean actual = specialSupport.resolve(trouble);
        assertTrue(actual);
    }
    @Test
    public void testResolveWithEven() {
        SpecialSupport specialSupport = new SpecialSupport("test", 100);
        when(trouble.getNumber()).thenReturn(2);
        boolean actual = specialSupport.resolve(trouble);
        assertFalse(actual);
    }
}
