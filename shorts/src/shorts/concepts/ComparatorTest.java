package shorts.concepts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

class Student {
    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

    public String getName() {
        return name;
    }
}

class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.age, s2.age);
    }
}

public class ComparatorTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 22));
        students.add(new Student("Bob", 20));
        students.add(new Student("Charlie", 21));

        //Collections.sort(students, new AgeComparator());

        methodReference2(students);
//        for (Student s : students) {
//            System.out.println(s);
//        }
    }

    public static void anonymousClass(List<Student> students){
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.age, s2.age);
            }
        });
    }

    public static void lambdaExpression(List<Student> students) {
        Collections.sort(students, (s1, s2) -> Integer.compare(s1.age, s2.age));
    }

    public  static void methodReference(List<Student> students){
        Function<Student, Integer> order = s -> s.age;
        Collections.sort(students, Comparator.comparingInt(s -> s.age));
    }

    public  static void methodReference2(List<Student> students){
        Function<Student, String> byName = s -> s.name;//Student::getNHame
        Collections.sort(students, Comparator.comparing(byName));
        for (Student s : students) {
            System.out.println(s);
        }
        Collections.sort(students, Comparator.comparing(byName).reversed());
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
