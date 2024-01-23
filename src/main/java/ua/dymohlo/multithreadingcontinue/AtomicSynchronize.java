package ua.dymohlo.multithreadingcontinue;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicSynchronize {
    public static AtomicInteger atomicInteger = new AtomicInteger();

    public static void IncrementAtomicInteger() {
        Thread firstThread = new Thread(() -> {
            integerIncrement();
        });

        Thread secondThread = new Thread(() -> {
            integerIncrement();
        });

        firstThread.start();
        secondThread.start();
        try {
            firstThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            secondThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(atomicInteger.get());
    }

    private static void integerIncrement() {
        for (int i = 0; i < 100_000; i++) {
            atomicInteger.incrementAndGet();
        }
    }
}
