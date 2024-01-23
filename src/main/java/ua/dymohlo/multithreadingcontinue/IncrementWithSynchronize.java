package ua.dymohlo.multithreadingcontinue;

public class IncrementWithSynchronize {
    private static Integer counter = 0;
    private static Object lock = new Object();

    public static void incrementWithSynchronize() {
        Thread firstThread = new Thread(() -> {
            incrementCounter();
        });
        Thread secondThread = new Thread(() -> {
            incrementCounter();
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

        System.out.println(counter);
    }

    private static void incrementCounter() {
        synchronized (lock) {
            for (int i = 0; i < 10_000; i++) {
                counter++;
            }
        }
    }
}
