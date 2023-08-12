package concurrent.threadpool;

import java.util.concurrent.*;

public class ThreadPoolRunner {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
//        scheduledThreadPool.schedule(() -> System.out.println("ok!"), 3, TimeUnit.SECONDS);
        scheduledThreadPool.scheduleAtFixedRate(() ->
                System.out.println("ok!"), 3, 3, TimeUnit.SECONDS); // Бесконечный цикл с задержкой 3с с повтором каждые 3с

//        scheduledThreadPool.shutdown();
//        scheduledThreadPool.awaitTermination(1, TimeUnit.MINUTES);
    }
    public static void test(String[] args) throws InterruptedException, ExecutionException {
//        Executors.newSingleThreadExecutor();
//        Executors.newFixedThreadPool(5);
//        Executors.newCachedThreadPool();
//
//        Executors.newScheduledThreadPool(3);
//        Executors.newWorkStealingPool();

        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(3);

        Future<Integer> future = threadPool.submit(() -> {
            Thread.sleep(2000);
            System.out.println("It's Callable");
            return 1;
        });


        System.out.println("Result: " + future.get());
        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("main ends");
    }
}
