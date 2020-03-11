public class LimitSupport extends Support{
    public LimitSupport(String name) {
        super(name);
    }
    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
