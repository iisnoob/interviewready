package designpatterns.creational.abstractfactory.windows;

import designpatterns.creational.abstractfactory.Button;
import designpatterns.creational.abstractfactory.Checkbox;
import designpatterns.creational.abstractfactory.UIFactory;

public class WindowsFactory implements UIFactory {
    @Override
    public Button createButtonObject() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckoutObject() {
        return new WindowsCheckbox();
    }
}
