package newInterface;

import java.util.Random;

public interface NewInterfacable {

    void printNew();

    default void printRandom() {
        System.out.println(new Random().nextInt());
    }

}
