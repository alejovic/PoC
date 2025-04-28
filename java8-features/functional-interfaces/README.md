# Java Stream API & Functional Interfaces Cheat Sheet

---

## Most Commonly Used Functional Interfaces

| Interface           | Abstract Method         | Purpose                                 | Example |
|:--------------------|:-------------------------|:----------------------------------------|:--------|
| `Predicate<T>`       | `boolean test(T t)`        | Tests a condition, returns boolean       | `x -> x > 5` |
| `Function<T, R>`     | `R apply(T t)`             | Transforms T into R                     | `x -> x.toString()` |
| `Consumer<T>`        | `void accept(T t)`         | Performs an action on T                  | `x -> System.out.println(x)` |
| `Supplier<T>`        | `T get()`                  | Supplies a value of T                    | `() -> new Random().nextInt()` |
| `UnaryOperator<T>`   | `T apply(T t)`             | Special case of Function<T, T>           | `x -> x * 2` |
| `BinaryOperator<T>`  | `T apply(T t1, T t2)`       | Combines two Ts into one                 | `(a, b) -> a + b` |
| `BiFunction<T,U,R>`  | `R apply(T t, U u)`         | Takes two inputs, returns R              | `(a, b) -> a + b.length()` |
| `BiPredicate<T,U>`   | `boolean test(T t, U u)`    | Tests two inputs                        | `(a, b) -> a.equals(b)` |

---

## Types of Stream Operations

### Intermediate Operations
- Build the pipeline, return another stream.
- **Lazy** evaluation.

Examples:
```java
.filter(x -> x > 10)
.map(String::toUpperCase)
.sorted()
.distinct()
.limit(5)
.flatMap(List::stream)
```

### Terminal Operations
- Trigger the processing.
- Produce a result or side-effect.

Examples:
```java
.collect(Collectors.toList())
.forEach(System.out::println)
.reduce((a, b) -> a + b)
.count()
.anyMatch(x -> x > 10)
```

---

## Simple Java Examples

### Predicate Example
```java
Predicate<Integer> isPositive = num -> num > 0;
System.out.println(isPositive.test(5));  // true
```

### Function Example
```java
Function<Integer, String> toStringFunction = num -> "Number: " + num;
System.out.println(toStringFunction.apply(10)); // "Number: 10"
```

### Consumer Example
```java
Consumer<String> printMessage = message -> System.out.println("Hello, " + message);
printMessage.accept("World"); // Hello, World
```

### Supplier Example
```java
Supplier<Double> randomSupplier = () -> Math.random();
System.out.println(randomSupplier.get()); // e.g., 0.542352
```

### UnaryOperator Example
```java
UnaryOperator<Integer> doubler = x -> x * 2;
System.out.println(doubler.apply(4)); // 8
```

### BinaryOperator Example
```java
BinaryOperator<Integer> add = (a, b) -> a + b;
System.out.println(add.apply(5, 7)); // 12
```

### Full Stream Example
```java
List<String> names = List.of("Alex", "Brian", "Charles", "David", "Eve");

List<String> result = names.stream()
    .filter(n -> n.length() > 3)
    .map(String::toUpperCase)
    .sorted()
    .collect(Collectors.toList());

System.out.println(result); // [ALEX, BRIAN, CHARLES, DAVID]
```

---

## Quick Mind Map
```
Stream
 ├── Source
 ├── Intermediate Operations
 │    ├── Stateless (filter, map)
 │    └── Stateful (sorted, distinct)
 └── Terminal Operation
      ├── collect
      ├── forEach
      └── reduce
```

