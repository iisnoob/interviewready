package designpatterns.abstractfactory.windows;

import designpatterns.abstractfactory.Checkbox;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Windows checkbox!");
    }
}
