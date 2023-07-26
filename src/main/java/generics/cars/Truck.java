package generics.cars;

import generics.Automobile;
import generics.interfaces.Space;
import generics.parameters.CarBody;
import generics.parameters.CarColor;
import generics.parameters.Engine;
import generics.parameters.Tyres;

public class Truck extends Automobile implements Space {
    private final CarrierSpace space;

    public Truck(Engine engine, CarBody body, CarColor color, Tyres tyres, CarrierSpace space) {
        super(engine, body, color, tyres);
        this.space = space;
    }

    @Override
    public int accelerate(CarBody carBody) {
        return getEngine().accelerate(carBody)/getSpace();
    }

    @Override
    public int getSpace() {
        return space.getSpace();
    }
}
