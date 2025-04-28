What is the Stream API for?
---
* Stream API processes collections of data in a declarative, functional style.
* Focuses on what to do with data (not how to do it).

### Connection to Functional Programming
Streams embrace functional programming: functions as first-class citizens, immutability, side-effect-free operations.

Operations are often chained in a pipeline.

### Lambda Expressions
* Stream operations often use lambda expressions (x -> x * 2) to define behaviors.
* Lambdas make code more concise and readable.

### Pipelines
```
[Source: Collection, Array, etc.]
          |
          v
+------------------+
| Intermediate Op 1|   (e.g., filter)
+------------------+
          |
          v
+------------------+
| Intermediate Op 2|   (e.g., map)
+------------------+
          |
          v
+------------------+
| Intermediate Op 3|   (e.g., sorted)
+------------------+
          |
          v
+------------------+
| Terminal Op      |   (e.g., collect, forEach)
+------------------+
          |
          v
 [Result: List, count, side effect...]

```
A stream pipeline consists of:

1. Source (e.g., a collection, array, generator)
2. Intermediate operations (e.g., filter, map) — lazy operations that transform the stream
3. Terminal operation (e.g., collect, forEach) — triggers the execution

#### Intermediate Operations
1. Return another stream (allow chaining).
2. Lazy: they don't process data until a terminal operation is invoked.
3. Examples:
  * filter()
  * map()
  * sorted()
  * distinct()
  * limit()

#### Terminal Operations
1. End the stream pipeline.
2. Actually process the data.
3. Examples:
   * forEach()
   * collect()
   * reduce()
   * count()
   * anyMatch(), allMatch()

### Suppliers and Consumers
**Supplier<T>:** provides a value when needed (() -> new Object()).
* Used in generating streams (Stream.generate()).

**Consumer<T>:** takes a value and performs an action (x -> System.out.println(x)).
* Used in terminal operations like forEach().