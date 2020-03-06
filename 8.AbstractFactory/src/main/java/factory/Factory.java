package factory;

public abstract class Factory {
    public static Factory getFactory() {
        Factory factory = null;
        return factory;
    }

    public abstract Link createLink(String caption, String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title, String author);
}
