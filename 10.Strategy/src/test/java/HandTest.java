import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HandTest {
    @Test
    public void testGetHand() throws Exception{
        Hand guu = Hand.getHand(Hand.HAND_VALUE_GUU);
        Hand cho = Hand.getHand(Hand.HAND_VALUE_CHO);
        Hand paa = Hand.getHand(Hand.HAND_VALUE_PAA);

        assertEquals("グー", guu.toString());
        assertEquals("チョキ", cho.toString());
        assertEquals("パー", paa.toString());
    }
}
