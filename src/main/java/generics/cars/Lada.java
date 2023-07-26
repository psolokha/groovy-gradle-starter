package generics.cars;

import generics.parameters.CarBody;
import generics.parameters.CarColor;
import generics.parameters.Engine;
import generics.parameters.Tyres;

public class Lada extends Car{
    public Lada(Engine engine, CarBody body, CarColor color, Tyres tyres) {
        super(engine, body, color, tyres);
    }
}
