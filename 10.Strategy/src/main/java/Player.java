public class Player {
    private String name;
    private Strategy strategy;
    private int gameCount = 0;
    private int winCount = 0;
    private int loseCount = 0;
    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }
    public Hand nextHand() {
        return strategy.nextHand();
    }
    public void win() {
        strategy.study(true);
        winCount++;
        gameCount++;
    }
    public void lose() {
        strategy.study(false);
        loseCount++;
        gameCount++;
    }
    public void even() {
        strategy.study(false);
        gameCount++;
    }
    public String toString() {
        return "[" + name + ": " + gameCount + " games, " + winCount + " win, " + loseCount + " lose]";
    }
}
