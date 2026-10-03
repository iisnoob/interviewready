<h1>Factory Design Pattern</h1>

The <b>Factory Method Pattern</b> is a creational design pattern that provides a method for creating objects while allowing <b>subclasses or concrete implementations to decide which specific object should be created</b>.

The main goal is to avoid having the client directly depend on concrete classes when creating objects.

<br>

<b>Example:</b>

Suppose we have different types of notifications:

```text
Notification
    |
    +── EmailNotification
    |
    +── SMSNotification
```

Instead of the client directly doing:

```java
new EmailNotification();
```

or:

```java
new SmsNotification();
```

we define a factory method for creating the `Notification`.

For example:

```java
interface NotificationFactory {
    Notification createNotification();
}
```

Then different concrete factories decide what to create:

```java
class EmailNotificationFactory
        implements NotificationFactory {

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
```

and:

```java
class SmsNotificationFactory
        implements NotificationFactory {

    @Override
    public Notification createNotification() {
        return new SmsNotification();
    }
}
```

The client can then work with the factory interface:

```java
NotificationFactory factory =
        new EmailNotificationFactory();

Notification notification =
        factory.createNotification();

notification.send();
```

If we change:

```java
new EmailNotificationFactory()
```

to:

```java
new SmsNotificationFactory()
```

the client receives an `SmsNotification` instead.

The client therefore doesn't need to know the concrete creation logic.

<br>

<b>In our example:</b>

- `Notification` → <b>Product</b>
- `EmailNotification` / `SmsNotification` → <b>Concrete Products</b>
- `NotificationFactory` → <b>Factory</b>
- `EmailNotificationFactory` / `SmsNotificationFactory` → <b>Concrete Factories</b>
- `Main` → <b>Client</b>

<br>

<b>Note to self:</b> For simplicity, the `Main` class can be treated as the client.

<br>

<h2>Factory Method vs Simple Factory</h2>

<b>Simple Factory</b> has one factory that decides which concrete object to create:

```java
PaymentFactory.createPayment("UPI");
```

The factory itself contains the selection logic, such as `if-else` or `switch`.

<b>Factory Method</b> moves the creation decision to different concrete factory implementations:

```text
NotificationFactory
       |
       +── EmailNotificationFactory
       |       └── creates EmailNotification
       |
       +── SmsNotificationFactory
               └── creates SmsNotification
```

<br>

<b>Key idea:</b>

> Factory Method lets subclasses or concrete factory implementations decide which concrete product to create, while the client depends on abstractions rather than concrete classes.

<br>

<b>Interview note:</b> The <b>Factory Method</b> is one of the original 23 GoF Design Patterns. <b>Simple Factory</b> is a commonly used design idiom, but is not one of the original 23 GoF patterns.