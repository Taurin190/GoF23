public class CountDisplay extends Display {
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }
    public void multipleDisplay(int times) {
        impl.rawOpen();
        for (int i = 0; i < times; i++) {
            impl.rawPrint();
        }
        impl.rawClose();
    }
}
