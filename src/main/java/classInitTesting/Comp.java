package classInitTesting;

public class Comp {

    static {
        System.out.println("Comp static block");
    }

    int ssd;
    int ram;

    Comp() {
        System.out.println("Comp constructor");
    }

    static void message() {
        System.out.println("Comp static method");
    }

}
