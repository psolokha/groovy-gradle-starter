package generics.cars;

import generics.parameters.*;

public class Volkswagen extends Van{
    public Volkswagen(Engine engine, CarBody body, CarColor color, Tyres tyres, CarrierSpace space) {
        super(engine, body, color, tyres, space);
    }
}
