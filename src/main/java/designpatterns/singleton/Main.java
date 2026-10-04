package designpatterns.singleton;

public class Main {
    public static void main(String[] args) {
        CalculatorEager calculator = CalculatorEager.getInstance();
        CalculatorEager calculator1 = CalculatorEager.getInstance();
        CalculatorEager calculator2 = CalculatorEager.getInstance();
        calculator.a = 10;
        calculator.b = 5;
        System.out.println(calculator.sum());
        calculator.a = 50;
        System.out.println(calculator.sum());
        System.out.println(calculator1.sum());
        System.out.println(calculator2.sum());

        CalculatorLazy calculatorLazy = CalculatorLazy.getInstance();
        calculatorLazy.a = 2;
        calculatorLazy.b = 9;
        System.out.println(calculatorLazy.sum());

        CalculatorLazy calculatorLazy1 = CalculatorLazy.getInstance();
        System.out.println(calculatorLazy1.sum());
    }
}
