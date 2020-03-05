import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextBuilderTest {
    @Test
    public void testMakeTitle() throws Exception {
        TextBuilder builder = new TextBuilder();
        builder.makeTitle("Hello");
        String actual = builder.getResult();
        assertEquals("==============================\n「Hello」\n\n", actual);
    }
    @Test
    public void testMakeString() throws Exception {
        TextBuilder builder = new TextBuilder();
        builder.makeString("World");
        String actual = builder.getResult();
        assertEquals("■ World\n\n", actual);
    }
    @Test
    public void testMakeItems() throws Exception {
        TextBuilder builder = new TextBuilder();
        builder.makeItems(new String[]{"Hello", "World"});
        String actual = builder.getResult();
        assertEquals("・Hello\n・World\n\n", actual);
    }
    @Test
    public void testMakeClose() throws Exception {
        TextBuilder builder = new TextBuilder();
        builder.close();
        String actual = builder.getResult();
        assertEquals("==============================\n", actual);
    }
}
