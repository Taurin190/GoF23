import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RandomNumberGeneratorTest {
    @Mock
    Observer observer;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testExecute() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        generator.addObserver(observer);
        generator.execute();
        int number = generator.getNumber();
        verify(observer, times(20)).update(generator);
        assertTrue(number >= 0);
        assertTrue(number < 50);
    }
}
