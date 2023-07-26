package generics.cars;

import generics.Automobile;
import generics.interfaces.Space;
import generics.parameters.*;

public class Van extends Automobile implements Space {

    private final CarrierSpace space;

    public Van(Engine engine, CarBody body, CarColor color, Tyres tyres, CarrierSpace space) {
        super(engine, body, color, tyres);
        this.space = space;
    }

    @Override
    public int getSpace() {
        return space.getSpace();
    }

    @Override
    public int accelerate(CarBody carBody) {
        return getEngine().accelerate(carBody)/getSpace();
    }
}
