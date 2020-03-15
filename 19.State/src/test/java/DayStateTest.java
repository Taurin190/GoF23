import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DayStateTest {
    @Mock
    private Context context;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testDoClock() {
        DayState dayState = DayState.getInstance();
        dayState.doClock(context, 12);
        verify(context, times(0)).changeState(NightState.getInstance());
        dayState.doClock(context, 18);
        verify(context, times(1)).changeState(NightState.getInstance());
    }
    @Test
    public void testDoUse() {
        DayState dayState = DayState.getInstance();
        dayState.doUse(context);
        verify(context, times(1)).recordLog("金庫使用（昼間）");
    }
    @Test
    public void testDoAlarm() {
        DayState dayState = DayState.getInstance();
        dayState.doAlarm(context);
        verify(context, times(1)).callSecurityCenter("非常ベル（昼間）");
    }
    @Test
    public void testDoPhone() {
        DayState dayState = DayState.getInstance();
        dayState.doPhone(context);
        verify(context, times(1)).callSecurityCenter("通常の通話（昼間）");
    }
    @Test
    public void testToString() {
        DayState dayState = DayState.getInstance();
        assertEquals(dayState.toString(), "[昼間]");
    }
}
