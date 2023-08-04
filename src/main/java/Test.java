public class Test {

    public static void main(String[] args) {
        class TClass {
            public int getInt( int getInt) {
                return 1;
            }
        }

        TClass tc = null;
        try {
            int t = tc.getInt(5);
        }catch (NullPointerException ex) {
            System.out.println("ex. was caught!");
        }

        int[] arr = new int[10];
        for (int i = 0; i <= arr.length; i++) {
            try {
                System.out.println(arr[i]);
            }catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("too much!");
            }
        }

    }

}
