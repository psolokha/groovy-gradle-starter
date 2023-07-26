package generics.cars;

import generics.parameters.CarBody;
import generics.parameters.CarColor;
import generics.parameters.Engine;
import generics.parameters.Tyres;

public class Volkswagen extends Van{
    public Volkswagen(Engine engine, CarBody body, CarColor color, Tyres tyres, CarrierSpace space) {
        super(engine, body, color, tyres, space);
    }
}
