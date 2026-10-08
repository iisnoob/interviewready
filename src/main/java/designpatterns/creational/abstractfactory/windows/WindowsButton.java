package designpatterns.creational.abstractfactory.windows;

import designpatterns.creational.abstractfactory.Button;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Pressing Windows Button!");
    }
}
