package designpatterns.creational.abstractfactory.mac;

import designpatterns.creational.abstractfactory.Button;
import designpatterns.creational.abstractfactory.Checkbox;
import designpatterns.creational.abstractfactory.UIFactory;

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
