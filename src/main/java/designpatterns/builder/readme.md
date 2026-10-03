# Builder Pattern ⭐ IMPORTANT

## Definition

The **Builder Pattern** is a creational design pattern that allows us to **construct a complex object step-by-step**, instead of using a large constructor with many parameters.

It is especially useful when an object has **many optional parameters** or requires multiple configuration steps.

---

## Example

Suppose we have a `User` with several properties:

```java
User user = new User.Builder()
        .name("John")
        .age(30)
        .email("john@gmail.com")
        .country("India")
        .build();
```

Instead of:

```java
new User("John", 30, "john@gmail.com", "India", ...);
```

The Builder makes the construction **more readable and flexible**.

### Structure

```text
Client
  ↓
Builder
  ↓
configure step-by-step
  ↓
build()
  ↓
Complex Object
```

The important part is that methods such as:

```java
.name(...)
.age(...)
.email(...)
```

return the **Builder itself**, allowing method chaining:

```java
builder.name(...)
       .age(...)
       .email(...)
       .build();
```

---

## Real-World Java/Spring Examples

You may have already used the Builder Pattern in Spring without realizing it.

### WebClient

```java
WebClient webClient = WebClient.builder()
        .baseUrl("https://api.example.com")
        .defaultHeader("Authorization", token)
        .build();
```

### Spring Cloud Gateway

```java
return builder.routes()
        .route("user-service", r -> r
                .path("/users/**")
                .uri("http://user-service"))
        .build();
```

`WebClient.builder()` and `RouteLocatorBuilder` demonstrate the same idea: **configure an object step-by-step and finally call `build()` to create the final object.**

---

## Java 17 Note

Java 17 `record`s can be useful for concise immutable data objects, but they **do not replace the Builder Pattern**.

Use a Builder when construction involves many optional parameters, configuration steps, or complex construction logic.

---

## Key Idea

> **Builder = Build a complex object step-by-step instead of using a large constructor.**

### Interview Answer

> "Builder Pattern is a creational design pattern used to construct complex objects step-by-step. It improves readability when an object has many optional parameters and avoids large, difficult-to-read constructors."