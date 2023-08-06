package concurrent.exercises;

import java.util.LinkedList;
import java.util.Random;

public class ProducerThread extends Thread {
    private final LinkedList<Integer> list;

    public ProducerThread(LinkedList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list){
                produce();
            }
        }
    }

    private void produce() {
        try {
            if (list.size() < 10) {
                list.add(new Random().nextInt());
                System.out.println(Thread.currentThread().getName() + " added " + list.getLast() + " Size: " + list.size());
                Thread.sleep(new Random().nextInt(1000));
                list.notifyAll();
            } else {
                System.out.println(Thread.currentThread().getName() + " producer is waiting for free unit");
                list.wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "ProducerThread{" +
                "list=" + list +
                '}';
    }
}
