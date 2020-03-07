package listfactory;

import factory.Link;

public class ListLink extends Link {
    private String caption;
    private String url;
    public ListLink(String caption, String url) {
        super(caption);
        this.caption = caption;
        this.url = url;
    }

    @Override
    public String makeHTML() {
        return "<li><a href=\"" + url + "\"/>" + caption + "</a></li>";
    }
}
