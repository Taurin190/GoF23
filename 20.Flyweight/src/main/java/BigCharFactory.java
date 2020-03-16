import java.util.HashSet;
import java.util.Hashtable;

public class BigCharFactory {
    private Hashtable pool = new Hashtable();
    private static BigCharFactory singleton = new BigCharFactory();
    private BigCharFactory() {

    }
    public static BigCharFactory getInstance() {
        return singleton;
    }
    public synchronized BigChar getBigChar(char charName) {
        BigChar bigChar = (BigChar) pool.get(charName);
        if (bigChar == null) {
            bigChar = new BigChar(charName);
            pool.put(charName, bigChar);
        }
        return bigChar;
    }
}
