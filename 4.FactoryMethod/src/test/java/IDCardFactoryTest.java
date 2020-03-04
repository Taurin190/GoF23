import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IDCardFactoryTest {
    private PrintStream defaultPrintStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    @Mock
    private IDCard idCardMock1;
    @Mock
    private IDCard idCardMock2;
    @Mock
    private IDCard idCardMock3;
    @Before
    public void setup() {
        defaultPrintStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(byteArrayOutputStream)));
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void createProductTest() {
        Product idCard = new IDCardFactory().createProduct("test");
        idCard.use();
        System.out.flush();
        String actual = byteArrayOutputStream.toString();
        assertEquals("testのカードを作ります。\ntestのカードを使います。\n", actual);
    }
    @Test
    public void registerAndGetOwners() {
        IDCardFactory factory = new IDCardFactory();
        when(idCardMock1.getOwner()).thenReturn("test1");
        when(idCardMock2.getOwner()).thenReturn("test2");
        when(idCardMock3.getOwner()).thenReturn("test3");
        factory.registerProduct(idCardMock1);
        factory.registerProduct(idCardMock2);
        factory.registerProduct(idCardMock3);

        ArrayList owners = factory.getOwners();
        assertEquals(3, owners.size());
        assertEquals("test1", ((IDCard) owners.get(0)).getOwner());
        assertEquals("test2", ((IDCard) owners.get(1)).getOwner());
        assertEquals("test3", ((IDCard) owners.get(2)).getOwner());
    }
}
