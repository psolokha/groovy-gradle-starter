package functional;

import java.util.Comparator;

public class LambdaExample {
    public static void main(String[] args) {

        Comparator<Integer> comparator = new IntegerComparator();
        System.out.println(comparator.compare(25,100));

        Comparator<Integer> lambdaComparator = (Integer o1, Integer o2) -> {
            return Integer.compare(o1, o2);
        };
        System.out.println(lambdaComparator.compare(5,0));

    }

    private static class IntegerComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
        }
    }
}
