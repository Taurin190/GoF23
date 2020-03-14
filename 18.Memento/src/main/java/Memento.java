import java.util.ArrayList;
import java.util.List;

public class Memento {
    private int money;
    List fruits = new ArrayList();
    public Memento(int money) {
        this.money = money;
    }
    public int getMoney() {
        return money;
    }
    public void addFruit(String fruit) {
        fruits.add(fruit);
    }
    public List getFruits() {
        return fruits;
    }
}
