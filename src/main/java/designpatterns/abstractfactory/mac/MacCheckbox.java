package designpatterns.abstractfactory.mac;

import designpatterns.abstractfactory.Checkbox;

public class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Pressing Mac checkbox!");
    }
}
