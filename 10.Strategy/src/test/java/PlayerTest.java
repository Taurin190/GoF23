import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerTest {
    @Mock
    private Strategy strategy;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testNextHand() {
        Player player = new Player("test", strategy);
        when(strategy.nextHand()).thenReturn(Hand.getHand(Hand.HAND_VALUE_GUU));
        Hand actual = player.nextHand();
        assertEquals(Hand.getHand(Hand.HAND_VALUE_GUU), actual);
    }
    @Test
    public void testWin() {
        Player player = new Player("test", strategy);
        player.win();
        verify(strategy, times(1)).study(true);
    }
    @Test
    public void testLose() {
        Player player = new Player("test", strategy);
        player.lose();
        verify(strategy, times(1)).study(false);
    }
    @Test
    public void testEven() {
        Player player = new Player("test", strategy);
        player.even();
        verify(strategy, times(1)).study(false);
    }
    @Test
    public void testToString() {
        Player player = new Player("test", strategy);
        for (int i = 0; i < 3; i++) {
            player.win();
        }
        for (int i = 0; i < 5; i++) {
            player.lose();
        }
        for (int i = 0; i < 7; i++) {
            player.even();
        }
        String actual = player.toString();
        assertEquals("[test: 15 games, 3 win, 5 lose]", actual);
    }
}
