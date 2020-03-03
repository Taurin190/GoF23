public class StringDisplay extends AbstractDisplay{
    private String text;
    private int width;
    public StringDisplay(String text) {
        this.text = text;
        this.width = text.getBytes().length;
    }
    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + text + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
