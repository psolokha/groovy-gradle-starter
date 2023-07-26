package generics.cars;

import generics.Automobile;
import generics.parameters.CarBody;
import generics.parameters.CarColor;
import generics.parameters.Engine;
import generics.parameters.Tyres;

public class Car extends Automobile {
    public Car(Engine engine, CarBody body, CarColor color, Tyres tyres) {
        super(engine, body, color, tyres);
    }

    @Override
    public int accelerate(CarBody carBody) {
        return 0;
    }
}
