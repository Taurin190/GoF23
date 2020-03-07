import java.nio.charset.Charset;

public class StringDisplayImpl extends DisplayImpl {
    private String text;
    private int length;
    public StringDisplayImpl(String text) {
        this.text = text;
        length = text.getBytes(Charset.forName("Shift_JIS")).length;
    }
    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println("|" + text + "|");
    }

    @Override
    public void rawClose() {
        printLine();
    }
    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
