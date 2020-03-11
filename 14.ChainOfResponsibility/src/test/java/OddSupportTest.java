import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

public class OddSupportTest {
    @Mock
    private Trouble trouble;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testResolveWithOdd() {
        OddSupport oddSupport = new OddSupport("test");
        when(trouble.getNumber()).thenReturn(1);
        boolean actual = oddSupport.resolve(trouble);
        assertTrue(actual);
    }
    @Test
    public void testResolveWithEven() {
        OddSupport oddSupport = new OddSupport("test");
        when(trouble.getNumber()).thenReturn(2);
        boolean actual = oddSupport.resolve(trouble);
        assertFalse(actual);
    }
}
