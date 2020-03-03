public class CharDisplay extends AbstractDisplay{
    private String text;
    public CharDisplay(String text) {
        this.text = text;
    }
    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(text);
    }

    @Override
    public void close() {
        System.out.print(">>");
    }
}
