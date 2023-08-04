package functional;

import functional.helper.Student;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class FunctionExamle {

    public static void main(String[] args) {

        // №1 Найти среднее всех нечетных числел списка, делящихся на 5
        OptionalDouble average = IntStream.rangeClosed(1, 10)
                .filter(num -> num % 5 == 0)
                .average();

        average.ifPresent(System.out::println);

        // №2 Найти из списка кол-во уникальных строк длинной более 8 символов
        Stream<String> strStream = Stream.of(
                "dfgth",
                "3gtreg5uy,",
                "sfsdfdsfsdg",
                "123456789",
                "htrdfgsrhjjhters",
                "htrdfgsrhjjhters",
                "htrdfgsrhjjhters",
                "09",
                "nvdrjkvjnwlweknfkaew",
                "eokadwed"
        );

        System.out.println(strStream
                .filter(str -> str.length() > 8)
                //.collect(Collectors.toSet())
                //.size();
                .distinct()
                .count());
                //.forEach(System.out::println);

        // №3 Дана Map<String, Integer>. Найти сумму всех значений, длинна ключа которых > 7

        Map<String, Integer> map = Map.of(
                "sdfergsrg", 4,
                "sdfergsrgdgh", 7,
                "sdrg", 1111,
                "sdfer", 3,
                "sdfergsrxfgdg", 6);

        System.out.println(map.entrySet().stream()
                .filter(entry -> entry.getKey().length() > 7)
                .mapToInt(Map.Entry::getValue)
                .sum());

        // №4 Вывести конкатинацию чисел списка
        System.out.println(IntStream.range(0,10)
                .mapToObj(String::valueOf)
                .collect(joining(" - ", "Prefix here: ", ". Ends here!")));

        // №5 У класса Student вывести имя самого старшего человека, чье имя не превышает 15 символов
        List<Student> studList = List.of(
                new Student(35, "Lena"),
                new Student(13, "Petr"),
                new Student(45, "Vyacheslavovich"),
                new Student(23, "Poligraph Poligraphovich"),
                new Student(67, "Root"),
                new Student(2, "Vic"),
                new Student(78, "Turtle Mutant Leonardo"),
                new Student(305, "Dunkan McLoud"),
                new Student(27, "Eleanora"),
                new Student(27, "Eleanora1"),
                new Student(27, "Eleanora2"),
                new Student(27, "Eleanora3"),
                new Student(33, "Jesus Christ Superstar")
        );
/*
        studList.stream()
                .filter(stud -> stud.getName().length() < 15)
                .max(Comparator.comparing(Student::getAge)).map(Student::getName).ifPresent(System.out::println); // Если есть компаратор
*/

        studList.stream()
                .collect(groupingBy(Student::getAge,
                        mapping((s -> s.getName() + " - " + s.getAge()), toList())))
                .entrySet().forEach(System.out::println);
    }

}
