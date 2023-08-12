package concurrent.exercises.tasks.task2;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Task2Runner {
    public static void main(String[] args) {
        Random random = new Random();

        int[] array = new int[random.nextInt(100000000)];
        fillArray(array, random);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        trackTime(() -> findMax(array));
        trackTime(() -> {
            try {
                return findMaxParallel(array, executorService);
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executorService.shutdown();
    }

    private static int trackTime(Supplier<Integer> task) {
        long startTime = System.currentTimeMillis();
        int max = task.get();
        System.out.println(task + ": " + (System.currentTimeMillis() - startTime));
        return max;
    }

    private static int findMaxParallel(int[] array, ExecutorService executorService) throws ExecutionException, InterruptedException {
        return executorService.submit(() -> IntStream.of(array)
                .parallel()
                .max()
                .orElse(Integer.MIN_VALUE)).get();
    }

    private static int findMax(int[] array) {
        return IntStream.of(array)
                .max()
                .orElse(Integer.MIN_VALUE);
    }


    private static void fillArray(int[] array, Random random) {
        for (int i = 0; i < array.length-1; i++) {
            array[i] = random.nextInt(1, 301);
        }
    }
}
