package generics.cars;

import generics.interfaces.Space;

public class CarrierSpace implements Space {

    private final int space;
    public CarrierSpace(int space) {
        this.space = space;
    }

    @Override
    public int getSpace() {
        return space;
    }
}
