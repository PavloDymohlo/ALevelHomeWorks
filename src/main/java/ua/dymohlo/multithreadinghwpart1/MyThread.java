package ua.dymohlo.multithreadinghwpart1;

public class MyThread extends Thread{
    @Override
    public void run(){
        while (true){
            System.out.println("Hello, A-Level from class");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
