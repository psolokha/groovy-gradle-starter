package org.example;

public class Unit {
    public Unit(int id) {
        this.id = id;
    }
    private final int id;

    private boolean asBoolean() {
        return id > 10;
    }

    boolean isCase(Unit switchValue) {
        return this.id == switchValue.getId();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                '}';
    }
}
