package designpatterns.abstractfactory.mac;

import designpatterns.abstractfactory.Button;
import designpatterns.abstractfactory.Checkbox;
import designpatterns.abstractfactory.UIFactory;

public class MacFactory implements UIFactory {
    @Override
    public Button createButtonObject() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckoutObject() {
        return new MacCheckbox();
    }
}
