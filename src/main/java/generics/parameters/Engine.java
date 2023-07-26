package generics.parameters;

import generics.interfaces.Accelerate;

public class Engine implements Accelerate {

    int hp;
    int v;

    public Engine(int hp, int v) {
        this.hp = hp;
        this.v = v;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int accelerate(CarBody body) {
        return hp*100/body.getWeight();
    }
}
