import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DirectorTest {
    @Mock
    private Builder builderMock;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testConstruct() throws Exception {
        Director director = new Director(builderMock);
        director.construct();
        verify(builderMock, times(1)).makeTitle("Greeting");
        verify(builderMock, times(1)).makeString("朝から昼にかけて");
        verify(builderMock, times(1)).makeItems(new String[]{"おはようございます。", "こんにちは。"});
        verify(builderMock, times(1)).makeString("夜に");
        verify(builderMock, times(1)).makeItems(new String[]{"こんばんは。", "おやすみなさい。", "さようなら。"});
        verify(builderMock, times(1)).close();
    }
}
