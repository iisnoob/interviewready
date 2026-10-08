package designpatterns.structural.adapter.example1;

import designpatterns.structural.adapter.example2.RazorpaySDK;

// NOTE: It is Adapter + Factory
public class FlexiblePaymentAdapter implements PaymentProcessor {

    private final PayPalAPI payPalAPI;
    private final RazorpaySDK razorpaySDK;

    public FlexiblePaymentAdapter(PayPalAPI payPalAPI, RazorpaySDK razorpaySDK) {
        this.payPalAPI = payPalAPI;
        this.razorpaySDK = razorpaySDK;
    }

    @Override
    public void pay(Double amount, String type) {
        if (type.equalsIgnoreCase("paypal")) {
            payPalAPI.makePayment(amount);
        } else if (type.equalsIgnoreCase("razorpay")) {
            razorpaySDK.makePayment(amount);
        } else {
            throw new IllegalArgumentException("Invalid payment provider!");
        }
    }
}
