import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class NightStateTest {
    @Mock
    private Context context;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testDoClock() {
        NightState nightState = NightState.getInstance();
        nightState.doClock(context, 7);
        verify(context, times(0)).changeState(DayState.getInstance());
        nightState.doClock(context, 10);
        verify(context, times(1)).changeState(DayState.getInstance());
    }
    @Test
    public void testDoUse() {
        NightState nightState = NightState.getInstance();
        nightState.doUse(context);
        verify(context, times(1)).callSecurityCenter("非常：夜間の金庫使用！");
    }
    @Test
    public void testDoAlarm() {
        NightState nightState = NightState.getInstance();
        nightState.doAlarm(context);
        verify(context, times(1)).callSecurityCenter("非常ベル（夜間）");
    }
    @Test
    public void testDoPhone() {
        NightState nightState = NightState.getInstance();
        nightState.doPhone(context);
        verify(context, times(1)).recordLog("夜間の通話録音");
    }
    @Test
    public void testToString() {
        NightState nightState = NightState.getInstance();
        assertEquals(nightState.toString(), "[夜間]");
    }
}
