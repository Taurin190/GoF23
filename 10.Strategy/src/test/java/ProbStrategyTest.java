import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class ProbStrategyTest {
    @Test
    public void testNextHand() throws Exception {
        Strategy strategy = new ProbStrategy(0);
        Hand hand = strategy.nextHand();
        Hand guu = Hand.getHand(Hand.HAND_VALUE_GUU);
        Hand cho = Hand.getHand(Hand.HAND_VALUE_CHO);
        Hand paa = Hand.getHand(Hand.HAND_VALUE_PAA);
        assertTrue(hand == guu || hand == cho || hand == paa);
    }
    @Test
    public void testStudy() throws Exception {
        Strategy strategy = new ProbStrategy(0);
        boolean hasDifferentHandBeforeStudy = false;
        boolean hasDifferentHandAfterStudy = false;
        for (int i = 0; i < 10; i++) {
            if (strategy.nextHand() != Hand.getHand(Hand.HAND_VALUE_GUU)) {
                hasDifferentHandBeforeStudy = true;
                break;
            }
        }
        assertTrue("Error: only GUU occurs before study", hasDifferentHandBeforeStudy);
        strategy = new ProbStrategy(0);
        for (int i = 0; i < 10000; i++) {
            strategy.study(true);
        }
        for (int i = 0; i < 10; i++) {
            if (strategy.nextHand() != Hand.getHand(Hand.HAND_VALUE_GUU)) {
                hasDifferentHandAfterStudy = true;
                break;
            }
        }
        assertFalse("Error: CHO and PAA occur after study", hasDifferentHandAfterStudy);
    }
}
