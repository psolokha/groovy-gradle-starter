package concurrent.cyclingbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CBRocketDetailRunnable implements Runnable {
private final CBRocketDetail cbRocketDetail;
    private final CyclicBarrier cyclicBarrier;

    public CBRocketDetailRunnable(CBRocketDetail CBRocketDetail, CyclicBarrier cyclicBarrier) {
        this.cbRocketDetail = CBRocketDetail;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Preparing detail...: " + cbRocketDetail);
        try {
            Thread.sleep(1000);
            System.out.println("Detail is ready... :" + cbRocketDetail);
            cyclicBarrier.await();
            System.out.println("Detail is used! : " + cbRocketDetail);
        }  catch (BrokenBarrierException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
