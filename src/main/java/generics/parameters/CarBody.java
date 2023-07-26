package generics.parameters;

import generics.interfaces.Weight;

public class CarBody implements Weight {
    int weight;
    int doors;

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDoors() {
        return doors;
    }

    public CarBody(int doors, int weight) {
        this.doors = doors;
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }
}
