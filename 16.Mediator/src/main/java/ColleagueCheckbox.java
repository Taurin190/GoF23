import java.awt.*;
import java.awt.event.ItemEvent;

public class ColleagueCheckbox extends Checkbox implements Colleague  {
    private Mediator mediator;
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }
    public void itemStateChanged(ItemEvent e) {
        mediator.colleagueChanged(this);
    }
}
