package concurrent.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountLock {

    private static int generator = -1;
    private final Lock lock = new ReentrantLock();
    private int id;
    private int money;

    public AccountLock(int money) {
        this.money = money;
        this.id = generator++;
    }

    public void add(int money) {
        this.money += money;
    }

    public boolean takeOff(int money) {
        if (this.money >= money) {
            this.money -= money;
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }

    public Lock getLock() {
        return lock;
    }
}
