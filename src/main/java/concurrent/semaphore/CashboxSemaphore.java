package concurrent.semaphore;

public class CashboxSemaphore {
    private static int generator = 1;
    private int id;

    public CashboxSemaphore() {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cashbox{" +
                "id=" + id +
                '}';
    }
}
