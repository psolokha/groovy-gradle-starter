package concurrent.exercises;

import java.util.LinkedList;

public class ExerciseRunner {
    public static void main(String[] args) throws InterruptedException {
        LinkedList<Integer> intList = new LinkedList<>();

        ProducerThread producerThread1 = new ProducerThread(intList);
        ProducerThread producerThread2 = new ProducerThread(intList);
        ProducerThread producerThread3 = new ProducerThread(intList);
        ConsumerThread consumerThread = new ConsumerThread(intList);

        producerThread1.start();
        producerThread2.start();
        producerThread3.start();
        consumerThread.start();

        producerThread1.join();
        producerThread2.join();
        producerThread3.join();
        consumerThread.join();
    }
}
