package concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class BuyerThreadSemaphore implements Runnable {
    private final Semaphore cashboxSemaphores;

    public BuyerThreadSemaphore(Semaphore cashboxSemaphores) {
        this.cashboxSemaphores = cashboxSemaphores;
    }

    @Override
    public void run() {
        try {
            cashboxSemaphores.acquire();
            System.out.println(Thread.currentThread().getName() + " обслуживается какой-то кассе ");
            Thread.sleep(5);
            System.out.println(Thread.currentThread().getName() + " освобождаю какую-то кассу");
            cashboxSemaphores.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
