import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GamerTest {

    @Test
    public void testGetMoney() {
        Gamer gamer = new Gamer(10);
        int actual = gamer.getMoney();
        assertEquals(10, actual);
    }
    @Test
    public void testCreateMemento() {
        Gamer gamer = new Gamer(10);
        Memento actual = gamer.createMemento();
        assertEquals(10, actual.getMoney());
    }

}
