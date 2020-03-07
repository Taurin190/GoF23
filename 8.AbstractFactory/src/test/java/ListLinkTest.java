import listfactory.ListLink;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListLinkTest {
    @Test
    public void testMakeHTML() {
        ListLink listLink = new ListLink("テスト", "https://test.com");
        String actual = listLink.makeHTML();
        assertEquals("<li><a href=\"https://test.com\"/>テスト</a></li>" ,actual);
    }
}
