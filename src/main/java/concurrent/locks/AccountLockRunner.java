package concurrent.locks;

public class AccountLockRunner {
    public static void main(String[] args) throws InterruptedException {
        AccountLock accountLock1 = new AccountLock(20000);
        AccountLock accountLock2 = new AccountLock(20000);

        AccountLockThread accountLockThread1 = new AccountLockThread(accountLock1, accountLock2);
        AccountLockThread accountLockThread2 = new AccountLockThread(accountLock2, accountLock1);

        accountLockThread1.start();
        accountLockThread2.start();

        accountLockThread1.join();
        accountLockThread2.join();

        System.out.println(accountLock1);
        System.out.println(accountLock2);
    }
}
