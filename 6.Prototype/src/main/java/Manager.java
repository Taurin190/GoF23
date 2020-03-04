import java.util.Hashtable;

public class Manager {
    private Hashtable showcase = new Hashtable();
    public void register(String name, Product p) {
        showcase.put(name, p);
    }
    public Product create(String name) {
        Product p = (Product) showcase.get(name);
        if (p == null) {
            return p;
        }
        return p.createClone();
    }
}
