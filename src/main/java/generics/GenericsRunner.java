package generics;

import generics.parameters.CarrierSpace;
import generics.cars.Kamaz;
import generics.cars.Lada;
import generics.cars.Volkswagen;
import generics.parameters.CarBody;
import generics.parameters.CarColor;
import generics.parameters.Engine;
import generics.parameters.Tyres;

import java.util.ArrayList;
import java.util.List;

public class GenericsRunner {
    public static void main(String[] args) {
        Lada granta = new Lada(new Engine(105, 1), new CarBody(4, 900), new CarColor("white"), new Tyres("Kama"));
        Volkswagen transporter = new Volkswagen(new Engine(200, 2), new CarBody(4, 1800), new CarColor("green"), new Tyres("Continental"), new CarrierSpace(2));
        Kamaz master = new Kamaz(new Engine(500, 5), new CarBody(3, 6000), new CarColor("red"), new Tyres("Kama"), new CarrierSpace(6));

        List<Automobile> autos = new ArrayList<>();
        autos.add(granta);
        autos.add(transporter);
        autos.add(master);

        race(autos);
    }

    public static void race(List<? extends Automobile> autos) {
        for (Automobile auto : autos) {
            System.out.println(auto.accelerate(auto.getBody()));
        }
    }
}
