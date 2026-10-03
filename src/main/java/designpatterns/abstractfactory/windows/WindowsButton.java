package designpatterns.abstractfactory.windows;

import designpatterns.abstractfactory.Button;

public class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Pressing Windows Button!");
    }
}
