import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testIsStrongerThan() throws Exception {
        Hand guu = Hand.getHand(Hand.HAND_VALUE_GUU);
        Hand cho = Hand.getHand(Hand.HAND_VALUE_CHO);
        Hand paa = Hand.getHand(Hand.HAND_VALUE_PAA);

        assertFalse(guu.isStrongerThan(guu));
        assertTrue(guu.isStrongerThan(cho));
        assertFalse(guu.isStrongerThan(paa));

        assertFalse(cho.isStrongerThan(guu));
        assertFalse(cho.isStrongerThan(cho));
        assertTrue(cho.isStrongerThan(paa));

        assertTrue(paa.isStrongerThan(guu));
        assertFalse(paa.isStrongerThan(cho));
        assertFalse(paa.isStrongerThan(paa));
    }

    @Test
    public void testIsWeakerThan() throws Exception {
        Hand guu = Hand.getHand(Hand.HAND_VALUE_GUU);
        Hand cho = Hand.getHand(Hand.HAND_VALUE_CHO);
        Hand paa = Hand.getHand(Hand.HAND_VALUE_PAA);

        assertFalse(guu.isWeakerThan(guu));
        assertFalse(guu.isWeakerThan(cho));
        assertTrue(guu.isWeakerThan(paa));

        assertTrue(cho.isWeakerThan(guu));
        assertFalse(cho.isWeakerThan(cho));
        assertFalse(cho.isWeakerThan(paa));

        assertFalse(paa.isWeakerThan(guu));
        assertTrue(paa.isWeakerThan(cho));
        assertFalse(paa.isWeakerThan(paa));
    }
}
