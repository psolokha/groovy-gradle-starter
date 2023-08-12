package reflection.model;

import java.io.Serializable;

public class Proger extends Employee implements Serializable, Comparable {
    private String name;
    @MinAge(age = 21)
    private int age;

    public Proger(Long id, String name, Integer age) {
        super(id);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Proger{" +
                "name='" + name + '\''
                + ", id=" + super.getId() +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
