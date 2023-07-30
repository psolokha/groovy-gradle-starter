package hashcodeandequals;

public class EqualsRunner {
    public static void main(String[] args) {
        House kremlin = new House(1, "Moscow", "Red sq.");
        House home = new House(15, "Lubertsy", "Smirnovskaya");
        House dacha = new House(270, "Khorlovo", "sixth");
        House dacha1 = new House(270, "Khorlovo", "sixth");

        System.out.println(kremlin.hashCode());
        System.out.println(home.hashCode());
        System.out.println(dacha.hashCode());
        System.out.println(dacha1.hashCode());

        System.out.println(kremlin.equals(home));
        System.out.println(dacha.equals(dacha1));

    }
}
