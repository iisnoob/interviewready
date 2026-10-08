package designpatterns.creational.singleton;

public class CalculatorLazy {
    Integer a;
    Integer b;

    private static CalculatorLazy calculator;

    private CalculatorLazy() {
    }

    public int sum() {
        return a + b;
    }

    public static CalculatorLazy getInstance() {
        if (calculator == null) {
            calculator = new CalculatorLazy();
        }
        return calculator;
    }
}
