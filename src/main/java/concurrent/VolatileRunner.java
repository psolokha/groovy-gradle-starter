package concurrent;

public class VolatileRunner {
    /**
     * volatile - не использовать оптимизацию системы для хранения данных (примитивы, ссылки) (память -> кэш процессора)
     *
     * [RAM        flag = true]     стек оперативной памяти
     * [1 -------- flag = false]    кэш первого ядра
     * [2 -------- flag = true]     кэш второго ядра
     *
     */
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (!flag) {
                System.out.println("still false");
            }
        });

        thread1.start();

        Thread.sleep(5);

        Thread thread2 = new Thread(() -> {
            flag = true;
            System.out.println("flag is set");
        });

        thread2.start();
    }
}
