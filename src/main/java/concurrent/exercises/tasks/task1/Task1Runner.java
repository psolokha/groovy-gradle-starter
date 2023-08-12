package concurrent.exercises.tasks.task1;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task1Runner {
    public static void main(String[] args) throws InterruptedException {

        // ExecutorService executorService = Executors.newSingleThreadExecutor(); // Ver.1 - SingleThread
        ExecutorService executorService = Executors.newFixedThreadPool(3); // Ver.2 MultiThread
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers: ");
        while (scanner.hasNextInt()) {
            int seconds = scanner.nextInt();
            if (seconds < 0) {
                System.out.println("Finished.");
                break;
            }
            executorService.submit(() -> {
                Integer counter = threadLocal.get();
                threadLocal.set(counter == null ? 1 : ++counter);
                System.out.printf("Thread '%s' has '%d' tasks",
                        Thread.currentThread().getName(),
                        threadLocal.get());

                Thread.sleep(1000L * seconds);
                System.out.printf("Thread '%s' sleeped '%d' seconds%n",
                        Thread.currentThread().getName(),
                        seconds);

                return seconds;
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);
    }
}
