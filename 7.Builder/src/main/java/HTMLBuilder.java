import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLBuilder extends Builder {
    private String filename;
    @Override
    public void makeTitle(String title) {
        filename = title + ".html";
        File file = new File(filename);
        try {
            FileWriter filewriter = new FileWriter(file, true);
            filewriter.append("<html><head><title>" + title + "</title></head><body>\n");
            filewriter.append("<h1>" + title + "</h1>\n");
            filewriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void makeString(String str) {
        File file = new File(filename);
        try {
            FileWriter filewriter = new FileWriter(file, true);
            filewriter.append("<p>" + str + "</p>\n");
            filewriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void makeItems(String[] items) {
        File file = new File(filename);
        try {
            FileWriter filewriter = new FileWriter(file, true);
            filewriter.append("<ul>\n");
            for (int i = 0; i < items.length; i++) {
                filewriter.append("<li>" + items[i] + "</li>\n");
            }
            filewriter.append("</ul>\n");
            filewriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void close() {
        File file = new File(filename);
        try {
            FileWriter filewriter = new FileWriter(file, true);
            filewriter.append("</body></html>\n");
            filewriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getResult() {
        return filename;
    }
}
