package generics.cars;

import generics.parameters.*;

public class Kamaz extends Truck{
    public Kamaz(Engine engine, CarBody body, CarColor color, Tyres tyres, CarrierSpace space) {
        super(engine, body, color, tyres, space);
    }
}
