import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class WinningStrategyTest {
    @Test
    public void testNextHand() throws Exception {
        Strategy strategy = new WinningStrategy(0);
        Hand hand = strategy.nextHand();
        Hand guu = Hand.getHand(Hand.HAND_VALUE_GUU);
        Hand cho = Hand.getHand(Hand.HAND_VALUE_CHO);
        Hand paa = Hand.getHand(Hand.HAND_VALUE_PAA);
        assertTrue(hand == guu || hand == cho || hand == paa);
    }
    @Test
    public void testStudy() throws Exception {
        Strategy strategy = new WinningStrategy(0);
        Hand firstHand = strategy.nextHand();
        strategy.study(true);
        for (int i = 0; i < 10; i++) {
            assertEquals(firstHand, strategy.nextHand());
        }

        strategy.study(false);
        boolean hasChangedHand = false;
        for (int i = 0; i < 100; i++) {
            if (firstHand != strategy.nextHand()) {
                hasChangedHand = true;
                break;
            }
        }
        assertTrue("Error: 100 times same Hand created. study and nextHand are invalid.", hasChangedHand);
    }
}
