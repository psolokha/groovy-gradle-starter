package concurrent.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListThreadRunner {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> ints = Collections.synchronizedList(new ArrayList<>());

        ListThread listThread1 = new ListThread(ints);
        ListThread listThread2 = new ListThread(ints);
        ListThread listThread3 = new ListThread(ints);
        ListThread listThread4 = new ListThread(ints);
        ListThread listThread5 = new ListThread(ints);
        ListThread listThread6 = new ListThread(ints);
        ListThread listThread7 = new ListThread(ints);
        ListThread listThread8 = new ListThread(ints);
        ListThread listThread9 = new ListThread(ints);
        ListThread listThread10 = new ListThread(ints);
        ListThread listThread11= new ListThread(ints);

        listThread1.start();
        listThread2.start();
        listThread3.start();
        listThread4.start();
        listThread5.start();
        listThread6.start();
        listThread7.start();
        listThread8.start();
        listThread9.start();
        listThread10.start();
        listThread11.start();

        listThread1.join();
        listThread2.join();
        listThread3.join();
        listThread4.join();
        listThread5.join();
        listThread6.join();
        listThread7.join();
        listThread8.join();
        listThread9.join();
        listThread10.join();
        listThread11.join();

        System.out.println(ints);

    }
}
