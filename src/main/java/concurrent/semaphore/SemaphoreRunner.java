package concurrent.semaphore;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.stream.Stream;

public class SemaphoreRunner {
    public static void main(String[] args) throws InterruptedException {
        Semaphore cashboxes = new Semaphore(2);

        List<Thread> threads = Stream.of(new BuyerThreadSemaphore(cashboxes),
                        new BuyerThreadSemaphore(cashboxes),
                        new BuyerThreadSemaphore(cashboxes),
                        new BuyerThreadSemaphore(cashboxes),
                        new BuyerThreadSemaphore(cashboxes),
                        new BuyerThreadSemaphore(cashboxes),
                        new BuyerThreadSemaphore(cashboxes),
                        new BuyerThreadSemaphore(cashboxes),
                        new BuyerThreadSemaphore(cashboxes),
                        new BuyerThreadSemaphore(cashboxes),
                        new BuyerThreadSemaphore(cashboxes))
                .map(Thread::new)
                .peek(Thread::start)
                .toList();

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
