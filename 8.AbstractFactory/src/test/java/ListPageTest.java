import listfactory.ListLink;
import listfactory.ListPage;
import listfactory.ListTray;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ListPageTest {
    @Mock
    ListLink listLinkMock1;
    @Mock
    ListLink listLinkMock2;
    @Mock
    ListTray listTrayMock;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testMakeHTML() {
        ListPage listPage = new ListPage("テストページ", "TEST");
        String actual = listPage.makeHTML();
        assertEquals("<html><head><title>テストページ</title></head>\n" +
                "<body>\n" +
                "<h1>テストページ</h1>\n" +
                "<ul>\n" +
                "</ul>\n" +
                "<hr><address>TEST</address>\n" +
                "</body></html>", actual);
    }
    @Test
    public void testMakeHTMLWithContents() {
        ListPage listPage = new ListPage("テストページ", "TEST");
        when(listLinkMock1.makeHTML()).thenReturn("<li><a href=\"https://test1.com\"/>テスト1</a></li>\n");
        when(listLinkMock2.makeHTML()).thenReturn("<li><a href=\"https://test2.com\"/>テスト2</a></li>\n");
        when(listTrayMock.makeHTML()).thenReturn("<li>\nテストトレイ\n<ul>\n" +
                "<li><a href=\"https://test1.com\"/>テスト1</a></li>\n" +
                "<li><a href=\"https://test2.com\"/>テスト2</a></li>\n" +
                "</ul>\n</li>\n");
        listPage.add(listLinkMock1);
        listPage.add(listLinkMock2);
        listPage.add(listTrayMock);
        String actual = listPage.makeHTML();
        assertEquals("<html><head><title>テストページ</title></head>\n" +
                "<body>\n" +
                "<h1>テストページ</h1>\n" +
                "<ul>\n" +
                "<li><a href=\"https://test1.com\"/>テスト1</a></li>\n" +
                "<li><a href=\"https://test2.com\"/>テスト2</a></li>\n" +
                "<li>\nテストトレイ\n<ul>\n" +
                "<li><a href=\"https://test1.com\"/>テスト1</a></li>\n" +
                "<li><a href=\"https://test2.com\"/>テスト2</a></li>\n" +
                "</ul>\n</li>\n" +
                "</ul>\n" +
                "<hr><address>TEST</address>\n" +
                "</body></html>", actual);
    }
}
