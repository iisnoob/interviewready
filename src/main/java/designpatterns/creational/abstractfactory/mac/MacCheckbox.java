package designpatterns.creational.abstractfactory.mac;

import designpatterns.creational.abstractfactory.Checkbox;

public class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Pressing Mac checkbox!");
    }
}
