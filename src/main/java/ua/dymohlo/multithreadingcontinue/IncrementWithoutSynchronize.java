package ua.dymohlo.multithreadingcontinue;

public class IncrementWithoutSynchronize {
    private static Integer counter = 0;

    public static void incrementWithoutSynchronize() {
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
        for (int i = 0; i < 10_000; i++) {
            counter++;
        }
    }
}
