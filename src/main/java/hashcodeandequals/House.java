package hashcodeandequals;

import java.util.Objects;

public class House implements Comparable<House> {

    int num;
    String city;
    String street;

    public House(int num, String city, String street) {
        this.num = num;
        this.city = city;
        this.street = street;
    }

    public int getNum() {
        return num;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return num == house.num &&
                Objects.equals(city, house.city) &&
                Objects.equals(street, house.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, city, street);
    }

    @Override
    public int compareTo(House o) {
        return Integer.compare(this.num, o.num);
    }

    @Override
    public String toString() {
        return "House{" +
                "num=" + num +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

}
