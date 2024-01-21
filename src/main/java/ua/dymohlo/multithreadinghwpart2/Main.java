package ua.dymohlo.multithreadinghwpart2;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Counter());
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Counter.counter);
    }
}
