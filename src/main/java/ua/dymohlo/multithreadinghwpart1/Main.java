package ua.dymohlo.multithreadinghwpart1;

public class Main {
    public static void main(String[] args) {
        MyThread threadExtendsClass = new MyThread();
        MyRunnable threadImplementsInterface = new MyRunnable();
        Thread thread = new Thread(threadImplementsInterface);
        threadExtendsClass.start();
        System.out.println();
        thread.start();
    }
}
