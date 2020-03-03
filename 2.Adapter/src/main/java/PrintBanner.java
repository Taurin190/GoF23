public class PrintBanner extends Banner implements Print {
    public PrintBanner(String text) {
        super(text);
    }
    @Override
    public void printWeak() {
        showWithParen();
    }
    @Override
    public void printStrong() {
        showWithAster();
    }
}
