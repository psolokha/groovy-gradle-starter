package concurrent;

public class ThreadRunner {
    public static void main(String[] args) {
        var simpleThread = new SimpleThread();
        System.out.println(simpleThread.getState() + ": " + simpleThread.getState());
        var lambdaThread = new Thread(() ->
                System.out.println("Hello from lambda: " + Thread.currentThread().getName()), "LambdaThread");
        var runnableThread = new Thread(new SimpleRunner(), "RunnableThread");
        simpleThread.start();
        System.out.println(simpleThread.getName() + ": " + simpleThread.getState());
        lambdaThread.start();
        runnableThread.start();

        try {
            simpleThread.join(100);
            System.out.println(simpleThread.getName() + ": " + simpleThread.getState());
            runnableThread.join();
            lambdaThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        simpleThread.interrupt();

        System.out.println(Thread.currentThread().getName());


    }
}
