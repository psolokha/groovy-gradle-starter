package concurrent.cyclingbarrier;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclingBarrierRunner {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(CBRocketDetail.values().length,
                () -> System.out.println("START from CyclingBarrier!!"));

        ExecutorService executorService = Executors.newCachedThreadPool();

        Arrays.stream(CBRocketDetail.values())
                .map(cbRocketDetail -> new CBRocketDetailRunnable(cbRocketDetail, cyclicBarrier))
                .forEach(executorService::submit);

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
