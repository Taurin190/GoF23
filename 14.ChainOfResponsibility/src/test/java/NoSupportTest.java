import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertFalse;

public class NoSupportTest {
    @Mock
    private Trouble trouble;
    @Test
    public void testResolve() {
        NoSupport noSupport = new NoSupport("test");
        boolean actual = noSupport.resolve(trouble);
        assertFalse(actual);
    }
}
