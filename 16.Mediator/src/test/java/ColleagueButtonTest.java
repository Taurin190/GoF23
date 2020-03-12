import org.junit.Test;
import org.mockito.Mock;

import java.awt.event.ItemEvent;

public class ColleagueButtonTest {
    @Mock
    private Mediator mediator;
    @Mock
    private ItemEvent e;
    @Test
    public void testMediator() {
        ColleagueButton colleagueButton = new ColleagueButton();
        colleagueButton.setMediator(mediator);
        colleagueButton.itemStateChanged(e);
    }
}
