import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class LimitSupportTest {
    @Mock
    private Trouble trouble;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testResolveWithinLimit() {
        LimitSupport limitSupport = new LimitSupport("test", 100);
        when(trouble.getNumber()).thenReturn(10);
        boolean actual = limitSupport.resolve(trouble);
        assertTrue(actual);
    }
    @Test
    public void testResolveExceedLimit() {
        LimitSupport limitSupport = new LimitSupport("test", 100);
        when(trouble.getNumber()).thenReturn(10000);
        boolean actual = limitSupport.resolve(trouble);
        assertFalse(actual);
    }
}
