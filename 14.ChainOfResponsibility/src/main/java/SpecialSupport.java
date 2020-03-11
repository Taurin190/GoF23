public class SpecialSupport extends Support {
    public SpecialSupport(String name) {
        super(name);
    }
    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
