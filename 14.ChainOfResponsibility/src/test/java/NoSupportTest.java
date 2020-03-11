import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertFalse;

public class NoSupportTest {
    @Mock
    private Trouble trouble;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testResolve() {
        NoSupport noSupport = new NoSupport("test");
        boolean actual = noSupport.resolve(trouble);
        assertFalse(actual);
    }
}
