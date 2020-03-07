import listfactory.*;
import factory.*;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ListFactoryTest {
    @Test
    public void testCreateLink() throws Exception {
        Factory factory = ListFactory.getFactory("listfactory.ListFactory");
        Link actual = factory.createLink("テスト1", "https://test1.com");
        assertNotNull(actual);
    }
    @Test
    public void testCreateTray() throws Exception {
        Factory factory = ListFactory.getFactory("listfactory.ListFactory");
        Tray actual = factory.createTray("テスト1");
        assertNotNull(actual);
    }
    @Test
    public void testCreatePage() throws Exception {
        Factory factory = ListFactory.getFactory("listfactory.ListFactory");
        Page actual = factory.createPage("テスト1", "太郎");
        assertNotNull(actual);
    }
}
