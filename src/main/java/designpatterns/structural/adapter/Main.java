package designpatterns.structural.adapter;

import designpatterns.structural.adapter.example1.PayPalAPI;
import designpatterns.structural.adapter.example1.FlexiblePaymentAdapter;
import designpatterns.structural.adapter.example1.PaymentProcessor;
import designpatterns.structural.adapter.example2.RazorpaySDK;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new FlexiblePaymentAdapter(
                new PayPalAPI(),
                new RazorpaySDK()
        );
        paymentProcessor.pay(5000.0, "paypal");
        paymentProcessor.pay(1000.0, "razorpay");
        paymentProcessor.pay(10000.0, "upi");
    }
}
