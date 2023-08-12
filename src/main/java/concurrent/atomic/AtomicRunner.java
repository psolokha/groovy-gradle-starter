package concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicRunner {
    public static void main(String[] args) {
        // Atomics
        int value = 5;
        AtomicInteger atomicInteger = new AtomicInteger(value);
        atomicInteger.addAndGet(20);
        System.out.println(atomicInteger.incrementAndGet());

//        Unsafe unsafe = Unsafe.getUnsafe();
//        System.out.println(unsafe);
    }
}