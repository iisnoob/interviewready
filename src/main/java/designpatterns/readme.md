# Design Patterns — Java 17

A practical guide to **Design Patterns in Java 17**, focused on understanding the concepts, recognizing when to use them, and preparing for SDE/backend interviews.

---

# 📚 Table of Contents

1. [What Are Design Patterns?](#what-are-design-patterns)
2. [Types of Design Patterns](#types-of-design-patterns)
3. [Creational Patterns](#1-creational-patterns)
    - [Factory ⭐](#1-factory-)
    - [Singleton ⭐](#2-singleton-)
    - [Builder ⭐](#3-builder-)
    - [Abstract Factory](#4-abstract-factory)
    - [Prototype ⭐](#5-prototype)
4. [Structural Patterns](#2-structural-patterns)
    - [Adapter ⭐](#6-adapter)
    - [Bridge](#7-bridge)
    - [Composite](#8-composite)
    - [Decorator ⭐](#9-decorator)
    - [Facade](#10-facade)
    - [Flyweight](#11-flyweight)
    - [Proxy ⭐](#12-proxy)
5. [Behavioral Patterns](#3-behavioral-patterns)
    - [Chain of Responsibility ⭐](#13-chain-of-responsibility)
    - [Command](#14-command)
    - [Interpreter](#15-interpreter)
    - [Iterator](#16-iterator)
    - [Mediator](#17-mediator)
    - [Memento](#18-memento)
    - [Observer ⭐](#19-observer)
    - [State](#20-state)
    - [Strategy ⭐](#21-strategy)
    - [Template Method](#22-template-method)
    - [Visitor](#23-visitor)
6. [Priority List](#priority-list-for-interviews)
7. [Quick Comparison](#quick-comparison)

---

# What Are Design Patterns?

A **Design Pattern** is a reusable solution to a commonly occurring software design problem.

It is **not ready-made code**.

Instead, it is a **general approach/structure** that can be implemented in code.

### Simple example

Suppose you have different payment methods:

```text
UPI
Credit Card
PayPal
Net Banking
```

Instead of writing complicated `if-else` logic everywhere, a **Factory Pattern** can centralize the creation of payment objects.

---

# Types of Design Patterns

The classic **Gang of Four (GoF)** book defines **23 Design Patterns**.

They are divided into three categories:

```text
                 Design Patterns
                       |
        +--------------+--------------+
        |              |              |
   Creational      Structural     Behavioral
        |              |              |
   Object creation  Object         Object
                    composition    communication
```

---

# 1. Creational Patterns

Creational patterns focus on:

> **How objects are created.**

There are 5 GoF creational patterns:

1. **Factory ⭐ IMPORTANT**
2. **Singleton ⭐ IMPORTANT**
3. **Builder ⭐ IMPORTANT**
4. Abstract Factory
5. **Prototype ⭐ IMPORTANT**

---

# 1. Factory ⭐ IMPORTANT

## What problem does it solve?

Without a Factory, the client often has to know which concrete class to instantiate.

```java
Payment payment;

if (type.equals("UPI")) {
    payment = new UpiPayment();
} else if (type.equals("CARD")) {
    payment = new CardPayment();
}
```

This tightly couples the client to concrete implementations.

Factory moves this creation logic into a dedicated place.

---

## Definition

> Factory Pattern provides a method for creating objects without exposing the object creation logic to the client.

---

## Java 17 Example

```java
interface Payment {
    void pay();
}

class UpiPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Paying using UPI");
    }
}

class CardPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Paying using Card");
    }
}

class PaymentFactory {

    public static Payment createPayment(String type) {

        return switch (type.toUpperCase()) {
            case "UPI" -> new UpiPayment();
            case "CARD" -> new CardPayment();
            default -> throw new IllegalArgumentException(
                    "Invalid payment type"
            );
        };
    }
}
```

Client:

```java
Payment payment = PaymentFactory.createPayment("UPI");

payment.pay();
```

Output:

```text
Paying using UPI
```

---

## Key idea

```text
Client
   |
   v
Factory
   |
   +----> UpiPayment
   |
   +----> CardPayment
```

The client only knows:

```java
Payment
```

It does not need to directly create:

```java
new UpiPayment()
new CardPayment()
```

---

## Interview Point

Simple Factory is commonly used but is **not one of the original 23 GoF patterns**.

Do not confuse:

```text
Simple Factory
Factory Method
Abstract Factory
```

They are different concepts.

---

# 2. Singleton ⭐ IMPORTANT

## What problem does it solve?

Sometimes an application should have **only one instance** of a particular class.

Examples:

- Configuration manager
- Logger
- Cache manager
- Application-wide resource manager

---

## Definition

> Singleton ensures that a class has only one instance and provides a global access point to that instance.

---

## Basic Java 17 Example

```java
class DatabaseConnection {

    private static DatabaseConnection instance;

    private DatabaseConnection() {
    }

    public static DatabaseConnection getInstance() {

        if (instance == null) {
            instance = new DatabaseConnection();
        }

        return instance;
    }
}
```

Usage:

```java
DatabaseConnection db1 =
        DatabaseConnection.getInstance();

DatabaseConnection db2 =
        DatabaseConnection.getInstance();

System.out.println(db1 == db2);
```

Output:

```text
true
```

---

## Important Components

A Singleton usually has:

### 1. Private constructor

```java
private DatabaseConnection() {
}
```

Prevents:

```java
new DatabaseConnection();
```

from outside the class.

### 2. Static instance

```java
private static DatabaseConnection instance;
```

### 3. Static access method

```java
public static DatabaseConnection getInstance()
```

---

## Thread Safety

The basic implementation is **not thread-safe**.

For a thread-safe implementation, one common approach is:

```java
class Singleton {

    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {

        if (instance == null) {

            synchronized (Singleton.class) {

                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
```

This is called **Double-Checked Locking**.

---

## Enum Singleton

Java provides another robust approach:

```java
enum Singleton {

    INSTANCE;

    public void doSomething() {
        System.out.println("Doing something");
    }
}
```

Usage:

```java
Singleton.INSTANCE.doSomething();
```

---

# 3. Builder ⭐ IMPORTANT

## What problem does it solve?

Consider a class with many parameters:

```java
User user = new User(
        "John",
        30,
        "john@gmail.com",
        "1234567890",
        "India",
        true
);
```

This becomes difficult to read and maintain.

Builder allows us to construct the object **step-by-step**.

---

## Definition

> Builder Pattern separates the construction of a complex object from its representation.

---

## Java 17 Example

```java
class User {

    private final String name;
    private final int age;
    private final String email;
    private final String country;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
        this.country = builder.country;
    }

    public static class Builder {

        private String name;
        private int age;
        private String email;
        private String country;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder country(String country) {
            this.country = country;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
```

Usage:

```java
User user = new User.Builder()
        .name("John")
        .age(30)
        .email("john@gmail.com")
        .country("India")
        .build();
```

---

## Why Builder is useful

```text
Without Builder
      ↓
Long constructor
      ↓
Hard to read
      ↓
Hard to maintain


With Builder
      ↓
Step-by-step construction
      ↓
Readable
      ↓
Flexible
```

---

# 4. Abstract Factory

## What problem does it solve?

Factory generally creates **one type of product**.

Abstract Factory creates **families of related products**.

---

## Example

Suppose we have:

```text
Windows UI
    ├── Windows Button
    └── Windows Checkbox

Mac UI
    ├── Mac Button
    └── Mac Checkbox
```

---

## Product Interfaces

```java
interface Button {
    void render();
}

interface Checkbox {
    void render();
}
```

Implementations:

```java
class WindowsButton implements Button {

    @Override
    public void render() {
        System.out.println("Windows Button");
    }
}

class MacButton implements Button {

    @Override
    public void render() {
        System.out.println("Mac Button");
    }
}

class WindowsCheckbox implements Checkbox {

    @Override
    public void render() {
        System.out.println("Windows Checkbox");
    }
}

class MacCheckbox implements Checkbox {

    @Override
    public void render() {
        System.out.println("Mac Checkbox");
    }
}
```

Factory:

```java
interface UIFactory {

    Button createButton();

    Checkbox createCheckbox();
}
```

Windows factory:

```java
class WindowsUIFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
```

Mac factory:

```java
class MacUIFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
```

Client:

```java
UIFactory factory = new WindowsUIFactory();

Button button = factory.createButton();
Checkbox checkbox = factory.createCheckbox();
```

---

## Factory vs Abstract Factory

```text
Factory
   ↓
Creates an object

Abstract Factory
   ↓
Creates a family of related objects
```

---

# 5. Prototype ⭐ IMPORTANT

## What problem does it solve?

Sometimes creating an object from scratch is expensive or complicated.

Instead, we can create a new object by **copying an existing object**.

---

## Definition

> Prototype Pattern creates new objects by copying an existing object.

---

## Java Example

```java
class User implements Cloneable {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public User clone() {

        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

Usage:

```java
User original = new User("John");

User copy = original.clone();

copy.setName("Alice");

System.out.println(original.getName());
System.out.println(copy.getName());
```

Output:

```text
John
Alice
```

---

## Important

Prototype becomes particularly important when:

- Object creation is expensive
- Objects have many fields
- You want to create similar objects
- Copying is cheaper than constructing from scratch

---

# 2. Structural Patterns

Structural patterns focus on:

> **How objects/classes are combined.**

There are 7 GoF structural patterns:

1. **Adapter ⭐ IMPORTANT**
2. Bridge
3. Composite
4. **Decorator ⭐ IMPORTANT**
5. Facade
6. Flyweight
7. **Proxy ⭐ IMPORTANT**

---

# 6. Adapter ⭐ IMPORTANT

## What problem does it solve?

Two classes have incompatible interfaces but need to work together.

Adapter acts like a **translator**.

---

## Real-world example

A phone charger adapter converts:

```text
Socket
   ↓
Adapter
   ↓
Phone
```

---

## Java Example

Existing interface:

```java
interface PaymentProcessor {

    void pay(double amount);
}
```

Existing implementation:

```java
class StripePayment {

    public void makePayment(double amount) {
        System.out.println(
                "Stripe payment: " + amount
        );
    }
}
```

Adapter:

```java
class StripeAdapter implements PaymentProcessor {

    private final StripePayment stripePayment;

    public StripeAdapter(StripePayment stripePayment) {
        this.stripePayment = stripePayment;
    }

    @Override
    public void pay(double amount) {
        stripePayment.makePayment(amount);
    }
}
```

Client:

```java
PaymentProcessor processor =
        new StripeAdapter(new StripePayment());

processor.pay(1000);
```

---

## Key idea

```text
Client
  |
  v
Expected Interface
  |
  v
Adapter
  |
  v
Existing/Incompatible Class
```

---

# 7. Bridge

## What problem does it solve?

Bridge separates:

```text
Abstraction
     |
     |
Implementation
```

so that both can evolve independently.

---

## Example

```java
interface Device {
    void turnOn();
}

class TV implements Device {

    @Override
    public void turnOn() {
        System.out.println("TV ON");
    }
}

class Radio implements Device {

    @Override
    public void turnOn() {
        System.out.println("Radio ON");
    }
}
```

Remote:

```java
class Remote {

    protected final Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public void powerOn() {
        device.turnOn();
    }
}
```

Usage:

```java
Remote remote = new Remote(new TV());

remote.powerOn();
```

---

# 8. Composite

## What problem does it solve?

Composite allows us to treat:

```text
Individual object
```

and

```text
Group of objects
```

uniformly.

---

## Real-world example

A file system:

```text
Folder
 ├── File
 ├── File
 └── Folder
      ├── File
      └── File
```

Both files and folders can be treated as filesystem components.

---

## Java Example

```java
interface FileSystemComponent {

    void show();
}
```

File:

```java
class File implements FileSystemComponent {

    private final String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println("File: " + name);
    }
}
```

Folder:

```java
class Folder implements FileSystemComponent {

    private final String name;
    private final List<FileSystemComponent> children =
            new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        children.add(component);
    }

    @Override
    public void show() {

        System.out.println("Folder: " + name);

        for (FileSystemComponent child : children) {
            child.show();
        }
    }
}
```

---

# 9. Decorator ⭐ IMPORTANT

## What problem does it solve?

Decorator allows us to **add behavior to an object dynamically without modifying its original class**.

---

## Real-world example

Coffee:

```text
Coffee
  ↓
+ Milk
  ↓
+ Sugar
  ↓
+ Whipped Cream
```

---

## Java Example

Base interface:

```java
interface Coffee {

    double cost();

    String description();
}
```

Basic coffee:

```java
class BasicCoffee implements Coffee {

    @Override
    public double cost() {
        return 100;
    }

    @Override
    public String description() {
        return "Basic Coffee";
    }
}
```

Decorator:

```java
abstract class CoffeeDecorator implements Coffee {

    protected final Coffee coffee;

    protected CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}
```

Milk decorator:

```java
class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return coffee.cost() + 20;
    }

    @Override
    public String description() {
        return coffee.description() + ", Milk";
    }
}
```

Usage:

```java
Coffee coffee = new BasicCoffee();

coffee = new MilkDecorator(coffee);

System.out.println(coffee.description());
System.out.println(coffee.cost());
```

---

## Key idea

Instead of:

```java
class CoffeeWithMilkAndSugarAndCream
```

we dynamically compose:

```text
Coffee
 ↓
Milk
 ↓
Sugar
 ↓
Cream
```

---

# 10. Facade

## What problem does it solve?

A complex subsystem may contain many classes.

Facade provides a **simple interface** to that complexity.

---

## Example

Without Facade:

```java
videoDecoder.decode();
audioDecoder.decode();
fileReader.read();
processor.process();
```

With Facade:

```java
videoPlayer.play();
```

---

## Java Example

```java
class VideoDecoder {

    void decode() {
        System.out.println("Decoding video");
    }
}

class AudioDecoder {

    void decode() {
        System.out.println("Decoding audio");
    }
}

class VideoPlayerFacade {

    private final VideoDecoder videoDecoder =
            new VideoDecoder();

    private final AudioDecoder audioDecoder =
            new AudioDecoder();

    public void play() {

        videoDecoder.decode();
        audioDecoder.decode();

        System.out.println("Playing video");
    }
}
```

Client:

```java
VideoPlayerFacade player =
        new VideoPlayerFacade();

player.play();
```

---

# 11. Flyweight

## What problem does it solve?

Flyweight reduces memory usage by **sharing common objects** instead of creating many duplicate objects.

---

## Example

Imagine a game with:

```text
1,000,000 trees
```

Many trees may share common properties:

```text
Tree type
Texture
Color
```

Instead of storing those properties in every object, they can be shared.

---

## Key idea

```text
Many objects
      ↓
Shared common state
      ↓
Less memory
```

Flyweight is particularly useful when:

- There are huge numbers of similar objects
- Objects contain expensive shared data
- Memory usage is a concern

---

# 12. Proxy ⭐ IMPORTANT

## What problem does it solve?

Proxy provides a **stand-in object** that controls access to the real object.

---

## Real-world examples

Proxy can be used for:

- Access control
- Lazy loading
- Caching
- Logging
- Remote calls
- Security

---

## Java Example

Interface:

```java
interface Image {

    void display();
}
```

Real object:

```java
class RealImage implements Image {

    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println(
                "Loading " + fileName
        );
    }

    @Override
    public void display() {
        System.out.println(
                "Displaying " + fileName
        );
    }
}
```

Proxy:

```java
class ImageProxy implements Image {

    private final String fileName;
    private RealImage realImage;

    public ImageProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {

        if (realImage == null) {
            realImage = new RealImage(fileName);
        }

        realImage.display();
    }
}
```

Now:

```java
Image image = new ImageProxy("photo.jpg");
```

The actual image isn't loaded immediately.

It is loaded only when:

```java
image.display();
```

is called.

---

# 3. Behavioral Patterns

Behavioral patterns focus on:

> **How objects communicate and distribute responsibilities.**

There are 11 GoF behavioral patterns:

1. **Chain of Responsibility ⭐ IMPORTANT**
2. Command
3. Interpreter
4. Iterator
5. Mediator
6. Memento
7. **Observer ⭐ IMPORTANT**
8. State
9. **Strategy ⭐ IMPORTANT**
10. Template Method
11. Visitor

---

# 13. Chain of Responsibility ⭐ IMPORTANT

## What problem does it solve?

A request can pass through multiple handlers until one of them handles it.

---

## Real-world example

HTTP request:

```text
Request
   ↓
Authentication Filter
   ↓
Authorization Filter
   ↓
Logging Filter
   ↓
Business Logic
```

This is very relevant to backend development.

---

## Java Example

```java
interface Handler {

    void setNext(Handler handler);

    void handle(String request);
}
```

Authentication handler:

```java
class AuthenticationHandler implements Handler {

    private Handler next;

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    @Override
    public void handle(String request) {

        System.out.println(
                "Authentication checked"
        );

        if (next != null) {
            next.handle(request);
        }
    }
}
```

Authorization handler:

```java
class AuthorizationHandler implements Handler {

    private Handler next;

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    @Override
    public void handle(String request) {

        System.out.println(
                "Authorization checked"
        );

        if (next != null) {
            next.handle(request);
        }
    }
}
```

Build the chain:

```java
Handler authentication =
        new AuthenticationHandler();

Handler authorization =
        new AuthorizationHandler();

authentication.setNext(authorization);

authentication.handle("REQUEST");
```

Output:

```text
Authentication checked
Authorization checked
```

---

# 14. Command

## What problem does it solve?

Command converts a request into an object.

This allows us to:

- Queue commands
- Log commands
- Undo commands
- Schedule commands

---

## Example

```java
interface Command {

    void execute();
}
```

Command:

```java
class LightOnCommand implements Command {

    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
```

Receiver:

```java
class Light {

    public void turnOn() {
        System.out.println("Light ON");
    }
}
```

Usage:

```java
Light light = new Light();

Command command =
        new LightOnCommand(light);

command.execute();
```

---

# 15. Interpreter

## What problem does it solve?

Interpreter defines a way to interpret expressions based on a grammar.

---

## Example

A simple expression:

```text
5 + 10
```

can be represented as objects and interpreted.

Common use cases include:

- Simple query languages
- Expression evaluation
- Rules engines
- DSLs

---

# 16. Iterator

## What problem does it solve?

Iterator provides a way to traverse a collection **without exposing its internal structure**.

Java itself provides this pattern through:

```java
Iterator
```

Example:

```java
List<String> names =
        List.of("John", "Alice", "Bob");

Iterator<String> iterator =
        names.iterator();

while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

The client does not need to know how the list internally stores its elements.

---

# 17. Mediator

## What problem does it solve?

Mediator centralizes communication between objects.

Without Mediator:

```text
A ↔ B
A ↔ C
A ↔ D
B ↔ C
B ↔ D
...
```

This creates many dependencies.

With Mediator:

```text
       A
       |
       |
B ---- Mediator ---- C
       |
       |
       D
```

Objects communicate through the Mediator.

---

## Example

```java
interface ChatMediator {

    void sendMessage(
            String message,
            User user
    );

    void addUser(User user);
}
```

Users communicate through the mediator instead of directly communicating with each other.

---

# 18. Memento

## What problem does it solve?

Memento allows an object's state to be:

```text
Saved
  ↓
Modified
  ↓
Restored
```

---

## Real-world examples

- Undo functionality
- Editor history
- Game checkpoints

---

## Example

```java
class Editor {

    private String content;

    public void write(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String save() {
        return content;
    }

    public void restore(String state) {
        this.content = state;
    }
}
```

Usage:

```java
Editor editor = new Editor();

editor.write("Hello");

String backup = editor.save();

editor.write("Hello World");

editor.restore(backup);

System.out.println(editor.getContent());
```

Output:

```text
Hello
```

---

# 19. Observer ⭐ IMPORTANT

## What problem does it solve?

When one object changes, multiple other objects need to be notified.

---

## Real-world example

YouTube:

```text
Channel
   |
   +---- Subscriber 1
   |
   +---- Subscriber 2
   |
   +---- Subscriber 3
```

When the channel publishes a video, subscribers receive a notification.

---

## Java Example

Observer:

```java
interface Observer {

    void update(String message);
}
```

Concrete observer:

```java
class User implements Observer {

    private final String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {

        System.out.println(
                name + " received: " + message
        );
    }
}
```

Subject:

```java
class YouTubeChannel {

    private final List<Observer> subscribers =
            new ArrayList<>();

    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    public void uploadVideo(String title) {

        for (Observer subscriber : subscribers) {
            subscriber.update(title);
        }
    }
}
```

Usage:

```java
YouTubeChannel channel =
        new YouTubeChannel();

channel.subscribe(new User("John"));
channel.subscribe(new User("Alice"));

channel.uploadVideo("Java Design Patterns");
```

Output:

```text
John received: Java Design Patterns
Alice received: Java Design Patterns
```

---

# 20. State

## What problem does it solve?

An object's behavior changes based on its current state.

---

## Example

A vending machine:

```text
No Money
   ↓
Money Inserted
   ↓
Item Selected
   ↓
Item Dispensed
```

Instead of having a huge:

```java
if (state == ...)
```

block, each state can encapsulate its own behavior.

---

## Key idea

```text
Object
  |
  +---- State A → behavior A
  |
  +---- State B → behavior B
  |
  +---- State C → behavior C
```

---

# 21. Strategy ⭐ IMPORTANT

## What problem does it solve?

Strategy allows us to define multiple algorithms and choose one at runtime.

---

## Real-world example

Payment:

```text
Payment Strategy
       |
       +---- UPI
       |
       +---- Card
       |
       +---- PayPal
```

---

## Java Example

Strategy:

```java
interface PaymentStrategy {

    void pay(double amount);
}
```

UPI:

```java
class UpiStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println(
                "Paying ₹" + amount + " using UPI"
        );
    }
}
```

Card:

```java
class CardStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println(
                "Paying ₹" + amount + " using Card"
        );
    }
}
```

Context:

```java
class PaymentService {

    private final PaymentStrategy strategy;

    public PaymentService(
            PaymentStrategy strategy
    ) {
        this.strategy = strategy;
    }

    public void pay(double amount) {
        strategy.pay(amount);
    }
}
```

Usage:

```java
PaymentStrategy strategy =
        new UpiStrategy();

PaymentService service =
        new PaymentService(strategy);

service.pay(1000);
```

---

## Strategy vs if-else

Without Strategy:

```java
if (type.equals("UPI")) {
    // UPI logic
} else if (type.equals("CARD")) {
    // Card logic
} else if (type.equals("PAYPAL")) {
    // PayPal logic
}
```

With Strategy:

```java
PaymentStrategy strategy =
        new UpiStrategy();

strategy.pay(1000);
```

---

# 22. Template Method

## What problem does it solve?

Template Method defines the **overall algorithm structure** while allowing subclasses to customize individual steps.

---

## Example

```java
abstract class DataProcessor {

    public final void process() {

        readData();
        processData();
        saveData();
    }

    abstract void readData();

    abstract void processData();

    abstract void saveData();
}
```

CSV implementation:

```java
class CsvProcessor extends DataProcessor {

    @Override
    void readData() {
        System.out.println("Reading CSV");
    }

    @Override
    void processData() {
        System.out.println("Processing CSV");
    }

    @Override
    void saveData() {
        System.out.println("Saving CSV");
    }
}
```

The algorithm is fixed:

```text
read
 ↓
process
 ↓
save
```

but individual steps can vary.

---

# 23. Visitor

## What problem does it solve?

Visitor allows us to add new operations to existing object structures without modifying those classes.

---

## Basic idea

```text
Object Structure
      |
      v
   Visitor
      |
      +---- Operation A
      |
      +---- Operation B
```

It is useful when:

- Object structures are stable
- New operations are frequently added

But it can be more complex than simpler alternatives.

---

# ⭐ Priority List for Interviews

For your **Java backend/SDE interview preparation**, prioritize these 10:

## 🔥 Tier 1 — Important

### Creational

1. ⭐ **Factory**
2. ⭐ **Singleton**
3. ⭐ **Builder**
4. ⭐ **Prototype**

### Structural

5. ⭐ **Adapter**
6. ⭐ **Decorator**
7. ⭐ **Proxy**

### Behavioral

8. ⭐ **Observer**
9. ⭐ **Strategy**
10. ⭐ **Chain of Responsibility**

---

# 📊 Quick Comparison

| Pattern | Category | Main Idea |
|---|---|---|
| ⭐ Factory | Creational | Create objects |
| ⭐ Singleton | Creational | One instance |
| ⭐ Builder | Creational | Build complex objects |
| Abstract Factory | Creational | Create related object families |
| ⭐ Prototype | Creational | Copy existing objects |
| ⭐ Adapter | Structural | Make incompatible interfaces work together |
| Bridge | Structural | Separate abstraction and implementation |
| Composite | Structural | Treat objects and groups uniformly |
| ⭐ Decorator | Structural | Add behavior dynamically |
| Facade | Structural | Simplify a complex subsystem |
| Flyweight | Structural | Share objects to save memory |
| ⭐ Proxy | Structural | Control access to an object |
| ⭐ Chain of Responsibility | Behavioral | Pass request through handlers |
| Command | Behavioral | Encapsulate a request |
| Interpreter | Behavioral | Interpret expressions |
| Iterator | Behavioral | Traverse collections |
| Mediator | Behavioral | Centralize communication |
| Memento | Behavioral | Save/restore state |
| ⭐ Observer | Behavioral | Notify dependent objects |
| State | Behavioral | Behavior changes with state |
| ⭐ Strategy | Behavioral | Select algorithm at runtime |
| Template Method | Behavioral | Define algorithm skeleton |
| Visitor | Behavioral | Add operations without modifying classes |

---

# 🧠 One-Line Memory Trick

## Creational

> **"How should I CREATE the object?"**

```text
Factory
Singleton
Builder
Abstract Factory
Prototype
```

## Structural

> **"How should I CONNECT/COMPOSE objects?"**

```text
Adapter
Bridge
Composite
Decorator
Facade
Flyweight
Proxy
```

## Behavioral

> **"How should objects COMMUNICATE/BEHAVE?"**

```text
Chain of Responsibility
Command
Interpreter
Iterator
Mediator
Memento
Observer
State
Strategy
Template Method
Visitor
```

---

# ☕ Java 17 Relevance

These patterns are especially useful for a Java backend developer because they appear frequently in:

```text
Spring
Spring Boot
Spring Security
Spring MVC
Spring WebFlux
JPA / Hibernate
AWS SDKs
Database libraries
HTTP clients
Event-driven systems
Enterprise applications
```

You should particularly understand how these patterns relate to framework concepts:

| Pattern | Backend Relevance |
|---|---|
| ⭐ Factory | Object creation / dependency selection |
| ⭐ Singleton | Application-wide instances |
| ⭐ Builder | DTOs, configurations, immutable objects |
| ⭐ Prototype | Object copying |
| ⭐ Adapter | Integrating third-party APIs |
| ⭐ Decorator | Adding behavior around existing functionality |
| ⭐ Proxy | AOP, transactions, lazy loading, security |
| ⭐ Observer | Events and event-driven systems |
| ⭐ Strategy | Pluggable business logic |
| ⭐ Chain of Responsibility | Filters, middleware, request pipelines |

---

# 🎯 Recommended Learning Order

For interview preparation:

```text
1. Factory
      ↓
2. Singleton
      ↓
3. Builder
      ↓
4. Strategy
      ↓
5. Observer
      ↓
6. Chain of Responsibility
      ↓
7. Adapter
      ↓
8. Decorator
      ↓
9. Proxy
      ↓
10. Prototype
      ↓
11. Abstract Factory
      ↓
12. Remaining patterns
```

The first 10 give you a strong foundation for recognizing and discussing design patterns in **Java 17 backend system design and SDE interviews**.