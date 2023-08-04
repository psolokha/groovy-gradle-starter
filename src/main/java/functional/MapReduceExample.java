package functional;

import functional.helper.Student;

import java.util.Optional;
import java.util.stream.Stream;

/**
     * Students[3000_000]: max(age)
     * [1000_000] -> age -> max |
     * [1000_000] -> age -> max | -> max
     * [1000_000] -> age -> max |
     */
public class MapReduceExample {
    public static void main(String[] args) {
        System.out.println(300_000_000);

        Stream<Student> stream = Stream.of(
                new Student(18, "Pasha"),
                new Student(19, "Petya"),
                new Student(20, "Vasya"),
                new Student(21, "Lena"),
                new Student(19, "Olya"),
                new Student(18, "Grisha")
        );

        // #1
//         stream.parallel() // в много потоков
//                .map(Student::getAge)
//                .reduce(Math::max) // Optional!
//                .ifPresent(System.out::println);

         // #2
        Optional<Student> maybeStudent = stream.reduce((student1, student2) -> student1.getAge() > student2.getAge() ? student1 : student2);
        maybeStudent.ifPresent(System.out::println);
        maybeStudent.map(Student::getAge)
                .filter(age -> age > 20);
    }
}
