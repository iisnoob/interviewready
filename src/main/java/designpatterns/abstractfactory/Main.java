package designpatterns.abstractfactory;

import designpatterns.abstractfactory.mac.MacFactory;
import designpatterns.abstractfactory.windows.WindowsFactory;

public class Main {
    public static void main(String[] args) {
        UIFactory windowsFactory = new WindowsFactory();
        Button windowsButtonObject = windowsFactory.createButtonObject();
        windowsButtonObject.render();
        Checkbox windowsCheckoutObject = windowsFactory.createCheckoutObject();
        windowsCheckoutObject.render();

        UIFactory macFactory = new MacFactory();
        Button macButtonObject = macFactory.createButtonObject();
        macButtonObject.render();
        Checkbox macCheckboxObject = macFactory.createCheckoutObject();
        macCheckboxObject.render();
    }
}
