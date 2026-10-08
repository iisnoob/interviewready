<h1>Abstract Factory Pattern</h1>

A factory pattern is a design pattern where objects can be created without exposing the object creation logic to the client.

In the <b>Abstract Factory Pattern</b>, an abstract factory defines methods for creating a <b>family of related objects</b>, while concrete factory implementations decide which specific objects to create.

<br><br>

<b>Example:</b>

Suppose our application supports both Windows and Mac UI components.

```text
Windows Family
 ├── WindowsButton
 └── WindowsCheckbox

Mac Family
 ├── MacButton
 └── MacCheckbox
```

In our example:

- `UIFactory` → <b>Abstract Factory</b>
- `WindowsUIFactory` / `MacUIFactory` → <b>Concrete Factories</b>
- `Button` / `Checkbox` → <b>Abstract Products</b>
- `WindowsButton`, `WindowsCheckbox`, `MacButton`, `MacCheckbox` → <b>Concrete Products</b>
- `Main` → <b>Client</b>

The client can simply choose the required factory:

```java
UIFactory factory = new WindowsUIFactory();

factory.createButton().render();
factory.createCheckbox().render();
```

If the client instead uses:

```java
UIFactory factory = new MacUIFactory();
```

it automatically receives the corresponding Mac family of products.

The client does not need to know how `WindowsButton`, `WindowsCheckbox`, `MacButton`, or `MacCheckbox` are created.

<br>

<b>Note to self: For simplicity, the Main class can be treated as the client.</b>

<br>

<b>Key idea:</b>

> Abstract Factory creates <b>families of related objects</b> without exposing their concrete classes to the client.