package colllections;

import hashcodeandequals.House;

import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        int index = 0;
        House h1 = new House(48, "yyy", "iii");
        House h2 = new House(55, "zzz", "bbb");
        House h3 = new House(44, "www", "ddd");
        House h4 = new House(6, "lll", "ggg");
        House h5 = new House(90, "ghfg", "sdf");
        House h6 = new House(32, "32yd", "ggkhgg");
        House h7 = new House(4, "tyjr", "ggg");
        House h8 = new House(87, "lll", "jkyur");
        House h9 = new House(59, "gfd", "ioyp");
        House h10 = new House(40, "87567r", "dfwr");

        Map<House, Integer> treeHouse = new TreeMap<>(Comparator.comparing(House::getNum));
        treeHouse.put(h1, index++);
        treeHouse.put(h2, index++);
        treeHouse.put(h3, index++);
        treeHouse.put(h4, index++);
        treeHouse.put(h5, index++);
        treeHouse.put(h6, index++);
        treeHouse.put(h7, index++);
        treeHouse.put(h8, index++);
        treeHouse.put(h9, index++);
        treeHouse.put(h10, index++);

        for (Map.Entry house : treeHouse.entrySet()) {
            System.out.println(house.getKey() + " value: " + house.getValue());
        }

        System.out.println(System.lineSeparator());

        Set<String> set = new TreeSet<>();

        set.add("dfgdf");
        set.add("ghfghy");
        set.add("aweyhg");
        set.add("123");

        for (String s : set) {
            System.out.println(s);
        }

        System.out.println("-------------\n object removed\n");
        set.remove("123");
        set.forEach(System.out::println);



    }




}
