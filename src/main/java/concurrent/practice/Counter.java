package concurrent.practice;

public class Counter {
    private int counter;
    private static String description;

    public int getCounter() {
        return counter;
    }

    public static void init() {
        synchronized (Counter.class) {
            if (description == null) {
                description = "Test description";
            }
        }
    }

    public synchronized void synchronizedIncrement() {
        counter++;
    }

    public void synchronizedThisIncrement() {
        synchronized (this) {
            counter++;
        }
    }

    public int decrement() {
        return counter--;
    }
}
