package designpatterns.structural.adapter;

import designpatterns.structural.adapter.example1.PayPalAPI;
import designpatterns.structural.adapter.example1.FlexiblePaymentAdapter;
import designpatterns.structural.adapter.example1.PaymentProcessor;
import designpatterns.structural.adapter.example2.RazorpaySDK;

public class Main {
    public static void main(String[] args) {
        // Not ideal as it is mixing 2 patterns: adapter + factory
        PaymentProcessor paymentProcessor = new FlexiblePaymentAdapter(
                new PayPalAPI(),
                new RazorpaySDK()
        );
        paymentProcessor.pay(5000.0, "paypal"); // string param is mixing factory pattern
        paymentProcessor.pay(1000.0, "razorpay");
        paymentProcessor.pay(10000.0, "upi");
    }
}
