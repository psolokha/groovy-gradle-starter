package colllections;

import hashcodeandequals.House;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableRunner {
    public static void main(String[] args) {
        House h1 = new House(48, "yyy", "iii");
        House h2 = new House(55, "zzz", "bbb");
        House h3 = new House(44, "www", "ddd");
        House h4 = new House(44, "lll", "ggg");


        System.out.println(h1.compareTo(h2));
        System.out.println(h3.compareTo(h4));

        List<House> houseList = Arrays.asList(h1, h2, h3, h4);

        for (House house : houseList) {
            System.out.println(house);
        }

        System.out.println("----------------\nsorted:\n");

        Collections.sort(houseList);

        for (House house : houseList) {
            System.out.println(house);
        }

        System.out.println("---------------\nsorted using comparator:\n");

        Collections.sort(houseList, new StreetComparator());
        for (House house : houseList) {
            System.out.println(house);
        }

        System.out.println("---------------\nsorted using Comparator.comparing:\n");

        houseList.sort(Comparator.comparing(House::getCity).thenComparing(House::getNum));

        houseList.forEach(System.out::println);
    }

    public static class StreetComparator implements Comparator<House> {

        @Override
        public int compare(House o1, House o2) {
            return o1.getStreet().compareTo(o2.getStreet());
        }
    }
}
