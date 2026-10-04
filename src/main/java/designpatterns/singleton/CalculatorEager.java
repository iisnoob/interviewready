package designpatterns.singleton;

public class CalculatorEager {
    Integer a;
    Integer b;

    private static final CalculatorEager calculator = new CalculatorEager();

    private CalculatorEager() {
    }

    public int sum() {
        return a + b;
    }

    public static CalculatorEager getInstance() {
        return calculator;
    }
}
