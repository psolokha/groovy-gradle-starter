package generics;


import generics.interfaces.Accelerate;
import generics.parameters.CarBody;
import generics.parameters.CarColor;
import generics.parameters.Engine;
import generics.parameters.Tyres;

public abstract class Automobile implements Accelerate {

    Engine engine;
    CarBody body;
    CarColor color;
    Tyres tyres;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public CarBody getBody() {
        return body;
    }

    public void setBody(CarBody body) {
        this.body = body;
    }

    public CarColor getColor() {
        return color;
    }

    public void setColor(CarColor color) {
        this.color = color;
    }

    public Tyres getTyres() {
        return tyres;
    }

    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }

    public Automobile(Engine engine, CarBody body, CarColor color, Tyres tyres) {
        this.engine = engine;
        this.body = body;
        this.color = color;
        this.tyres = tyres;
    }
}
