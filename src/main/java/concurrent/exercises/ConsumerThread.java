package concurrent.exercises;

import java.util.LinkedList;
import java.util.Random;

public class ConsumerThread extends Thread {
    private final LinkedList<Integer> list;

    public ConsumerThread(LinkedList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                consume();
            }
        }
    }

    private void consume() {
        try {
            Thread.sleep(new Random().nextInt(10));
            if (!list.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + " removed " + list.getFirst());
                list.removeFirst();
                list.notifyAll();
            } else {
                System.out.println(Thread.currentThread().getName() + " consumer has no elements");
                list.wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "ConsumerThread{" +
                "list=" + list +
                '}';
    }
}
