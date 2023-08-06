package concurrent.account;

public class AccountThread extends Thread {
    private final Account accountFrom;
    private final Account accountTo;

    public AccountThread(Account from, Account to) {
        this.accountFrom = from;
        this.accountTo = to;
    }

    /**
     * 1 ------------ account1 -> wait() account2
     *                               X              deadlock
     * 2 ------------ account2 -> wait() account1
     *     @Override
     *     public void run() {
     *         for (int i = 0; i < 2000; i++) {
     *             synchronized (accountFrom) {
     *                 synchronized (accountTo) {
     *                     if (accountFrom.takeOff(10)) {
     *                         accountTo.add(10);
     *                     }
     *                 }
     *             }
     *         }
     *     }
     */
    @Override
    public void run() {
        synchronized (accountFrom) {
            synchronized (accountTo) {
                for (int i = 0; i < 2000; i++) {
                    if (accountFrom.takeOff(10)) {
                        accountTo.add(10);
                    }
                }
            }
        }
    }

}
