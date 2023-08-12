package reflection.tasks.task1;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Task1Annotations {
    public static void main(String[] args) throws NoSuchFieldException {
        Car toyota = new Car("Toyota", "Corolla");
        System.out.println(toyota);
        String sqlRequest = createRequest(toyota);

        System.out.println(sqlRequest);
    }

    private static String createRequest(Car car) throws NoSuchFieldException {
        Table table = car.getClass().getAnnotation(Table.class);
        Field[] fields = car.getClass().getDeclaredFields();

        String fieldValues = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Column.class))
                .peek(field -> field.setAccessible(true))
                .map(field -> {
                    try {
                        return String.valueOf(field.get(car));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(value -> "'" + value + "'")
                .collect(Collectors.joining(", "));

        String fieldNames = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Column.class))
                .map(field -> field.getAnnotation(Column.class))
                .map(Column::value)
                .collect(Collectors.joining(", "));

        return String.format("INSERT INTO %s.%s (%s) VALUES (%s);",
                table.scheme(),
                table.table(),
                fieldNames,
                fieldValues);
    }
}
