import java.util.Random;

public class ProbStrategy implements Strategy {
    private Random random;
    private int prevHand = Hand.HAND_VALUE_GUU;
    private int currentHand = Hand.HAND_VALUE_GUU;
    private int[][] history = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }
    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHand));
        int handValue = Hand.HAND_VALUE_GUU;
        if (bet < history[currentHand][0]) {
            handValue = Hand.HAND_VALUE_GUU;
        } else if (bet < history[currentHand][0] + history[currentHand][1]) {
            handValue = Hand.HAND_VALUE_CHO;
        } else {
            handValue = Hand.HAND_VALUE_PAA;
        }
        return Hand.getHand(handValue);
    }

    @Override
    public void study(boolean win) {
        if (win) {
            history[prevHand][currentHand]++;
        } else {
            history[prevHand][(currentHand + 1) %3]++;
            history[prevHand][(currentHand + 2) %3]++;
        }
    }

    private int getSum(int historyValue) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[historyValue][i];
        }
        return sum;
    }
}
