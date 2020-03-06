import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        TextBuilder textBuilder = new TextBuilder();
        HTMLBuilder htmlBuilder = new HTMLBuilder();
        Director textDirector = new Director(textBuilder);
        textDirector.construct();
        Director htmlDirector = new Director(htmlBuilder);
        htmlDirector.construct();

        System.out.println(textBuilder.getResult());
        String filename = htmlBuilder.getResult();
        Path file = Paths.get(filename);
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String str = br.readLine();
            while (str != null) {
                System.out.println(str);
                str = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
