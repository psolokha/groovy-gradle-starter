package colllections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinkedHashMapExample {

    public static void main(String[] args) {
        List<String> sourceList = List.of("9123", "23", "74335", "456777", "5");
        List<String> list = new ArrayList<>(sourceList);

        for (String line : list) {
            System.out.println(line);
        }

        System.out.println("--------------");
        Collections.sort(list);

        for (String line : list) {
            System.out.println(line);
        }
    }
}
