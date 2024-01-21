package ua.dymohlo.multithreadinghwpart2;

public class Counter implements Runnable{
    public static int counter = 0;
    @Override
    public void run() {
        for(int i=0; i<10;i++){
            counter++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
