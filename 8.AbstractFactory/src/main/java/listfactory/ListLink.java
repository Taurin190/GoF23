package listfactory;

import factory.Link;

public class ListLink extends Link {
    public ListLink(String caption, String url) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        return null;
    }
}
