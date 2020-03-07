import listfactory.ListLink;
import listfactory.ListTray;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ListTrayTest {
    @Mock
    ListLink listLinkMock1;
    @Mock
    ListLink listLinkMock2;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testMakeHTML() throws Exception{
        ListTray listTray = new ListTray("テストトレイ");
        String actual = listTray.makeHTML();
        assertEquals("<li>\nテストトレイ\n<ul>\n</ul>\n</li>\n", actual);
    }
    @Test
    public void testMakeHTMLWithLinks() throws Exception{
        ListTray listTray = new ListTray("テストトレイ");
        when(listLinkMock1.makeHTML()).thenReturn("<li><a href=\"https://test1.com\"/>テスト1</a></li>\n");
        when(listLinkMock2.makeHTML()).thenReturn("<li><a href=\"https://test2.com\"/>テスト2</a></li>\n");
        listTray.add(listLinkMock1);
        listTray.add(listLinkMock2);
        String actual = listTray.makeHTML();
        assertEquals("<li>\nテストトレイ\n" +
                "<ul>\n" +
                "<li><a href=\"https://test1.com\"/>テスト1</a></li>\n" +
                "<li><a href=\"https://test2.com\"/>テスト2</a></li>\n" +
                "</ul>\n</li>\n", actual);
    }
}
