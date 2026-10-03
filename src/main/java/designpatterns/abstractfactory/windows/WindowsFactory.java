package designpatterns.abstractfactory.windows;

import designpatterns.abstractfactory.Button;
import designpatterns.abstractfactory.Checkbox;
import designpatterns.abstractfactory.UIFactory;

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
