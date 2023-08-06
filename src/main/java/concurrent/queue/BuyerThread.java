package concurrent.queue;

import java.util.Queue;

public class BuyerThread implements Runnable {
    private final Queue<Cashbox> cashboxes;

    public BuyerThread(Queue<Cashbox> cashboxes) {
        this.cashboxes = cashboxes;
    }

    @Override
    public void run() {
        try {
            synchronized (cashboxes) {
                while (true) {
                    if (!cashboxes.isEmpty()) {
                        Cashbox cashbox = cashboxes.remove();
                        System.out.println(Thread.currentThread().getName() + " обслуживается в кассе " + cashbox);

                        cashboxes.wait(5);

                        System.out.println(Thread.currentThread().getName() + " освобождаю кассу " + cashbox);
                        cashboxes.add(cashbox);
                        cashbox.notifyAll();
                        break;
                    } else {
                        System.out.println(Thread.currentThread().getName() + " ожидаю свободную кассу ");
                        cashboxes.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
