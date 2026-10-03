package designpatterns.abstractfactory.mac;

import designpatterns.abstractfactory.Button;

public class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Pressing Mac button!");
    }
}
