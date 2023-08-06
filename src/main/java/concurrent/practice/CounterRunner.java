package concurrent.practice;

import java.util.List;

public class CounterRunner {
    public static void main(String[] args) {
        Counter counter = new Counter();

        List<CounterThread> threadList = List.of(
        new CounterThread(counter),
        new CounterThread(counter),
        new CounterThread(counter),
        new CounterThread(counter),
        new CounterThread(counter),
        new CounterThread(counter),
        new CounterThread(counter),
        new CounterThread(counter),
        new CounterThread(counter),
        new CounterThread(counter)
        );

        threadList.forEach(Thread::start);
        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println(counter.getCounter());

    }
}

