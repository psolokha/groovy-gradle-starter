package concurrent.locks;

public class AccountLockThread extends Thread {
    private final AccountLock accountLockFrom;
    private final AccountLock accountLockTo;

    public AccountLockThread(AccountLock from, AccountLock to) {
        this.accountLockFrom = from;
        this.accountLockTo = to;
    }

    /**
     * 1 ------------ account1 -> wait() account2
     * X              deadlock
     * 2 ------------ account2 -> wait() account1
     *
     * @Override public void run() {
     * for (int i = 0; i < 2000; i++) {
     * synchronized (accountFrom) {
     * synchronized (accountTo) {
     * if (accountFrom.takeOff(10)) {
     * accountTo.add(10);
     * }
     * }
     * }
     * }
     * }
     */
    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            lockAccounts();
            try{
                if (accountLockFrom.takeOff(10)) {
                    accountLockTo.add(10);
                }
            } finally {
                accountLockFrom.getLock().unlock();
                accountLockTo.getLock().unlock();
            }
        }
    }

    private void lockAccounts() {
        while (true) {
            boolean fromLock = accountLockFrom.getLock().tryLock();
            boolean toLock = accountLockTo.getLock().tryLock();
            if (fromLock && toLock) {
                break;
            }
            if (fromLock) {
                accountLockFrom.getLock().unlock();
            }
            if (toLock) {
                accountLockTo.getLock().unlock();
            }
        }
    }


}
