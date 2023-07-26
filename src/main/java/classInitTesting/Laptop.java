package classInitTesting;

public class Laptop extends Comp {

    static {
        System.out.println("Laptop static block");
    }

    Laptop() {
        System.out.println("Laptop constructor");
    }

    public static void message() {
        System.out.println("Laptop static method");
    }

}
