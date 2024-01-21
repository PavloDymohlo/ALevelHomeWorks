package ua.dymohlo.multithreadinghwpart1;

public class ThreadImplementsInterface implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("Hello, A-Level from Interface");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
