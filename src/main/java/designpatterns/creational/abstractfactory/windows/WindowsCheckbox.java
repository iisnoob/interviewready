package designpatterns.creational.abstractfactory.windows;

import designpatterns.creational.abstractfactory.Checkbox;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Windows checkbox!");
    }
}
