package listfactory;

import factory.Page;

public class ListPage extends Page {
    public ListPage(String title, String author) {
        super(title, author);
    }
    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html><head><title>" + title + "</title></head>\n");
        buffer.append("<body>\n");
        buffer.append("<h1>"+ title + "</h1>\n");
        buffer.append("<ul>\n");
        for (int i = 0; i < content.size(); i++) {
            buffer.append(content.get(i).makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append("<hr><address>" + author + "</address>\n");
        buffer.append("</body></html>");
        return buffer.toString();
    }
}
