package functional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamExample {

    public static void main(String[] args) {
        List<String> list = List.of("88","11", "22", "33", "44", "55", "66", "77");
/*
 Example:
        for (String s : list) {
            String value = s + s;
            Integer intValue = Integer.valueOf(value);
            if (intValue % 2 == 0) {
                System.out.println(intValue);
            }
        }
*/
        list.stream().
                map(value -> value + value).
                map(Integer::valueOf).
                filter(value -> value % 2 == 0).
                sorted().
                skip(1).
                limit(2).
                forEach(System.out::println);

        //IntStream, DoubleStream, LongStream
        int[] intArray = list.stream().mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(intArray));

        /*
        for (int i = 0; i < intArray.length; i++) {
          System.out.println(intArray[i])
         }
        */
        IntStream.range(0,intArray.length).forEach( i -> System.out.println(intArray[i]));


    }
}
