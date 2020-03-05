import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class ManagerTest {
    @Mock
    private Product productMock1;
    @Mock
    private Product productMock2;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testRegisterAndCreate() throws Exception {
        Manager manager = new Manager();
        when(productMock1.createClone()).thenReturn(productMock2);
        manager.register("test", productMock1);
        Product actual = manager.create("test");
        assertEquals(productMock2, actual);
    }
    @Test
    public void testRegisterAndFailToCreate() throws Exception {
        Manager manager = new Manager();
        when(productMock1.createClone()).thenReturn(productMock2);
        manager.register("test1", productMock1);
        Product actual = manager.create("test2");
        assertEquals(null, actual);
    }
}
