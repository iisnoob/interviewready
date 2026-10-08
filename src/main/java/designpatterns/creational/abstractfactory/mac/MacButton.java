package designpatterns.creational.abstractfactory.mac;

import designpatterns.creational.abstractfactory.Button;

public class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Pressing Mac button!");
    }
}
