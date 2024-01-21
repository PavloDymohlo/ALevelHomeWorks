package ua.dymohlo.multithreadinghwpart1;

public class Main {
    public static void main(String[] args) {
        ThreadExtendsClass threadExtendsClass = new ThreadExtendsClass();
        ThreadImplementsInterface threadImplementsInterface = new ThreadImplementsInterface();
        Thread thread = new Thread(threadImplementsInterface);
        threadExtendsClass.start();
        System.out.println();
        thread.start();
    }
}
