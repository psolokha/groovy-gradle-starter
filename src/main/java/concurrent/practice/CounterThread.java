package concurrent.practice;

public class CounterThread extends Thread{
    private final Counter counter;

    public CounterThread (Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.synchronizedIncrement();
        }
    }
}
