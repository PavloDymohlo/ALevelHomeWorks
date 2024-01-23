package ua.dymohlo.multithreadingcontinue;

public class Main {


    public static void main(String[] args) {
        IncrementWithoutSynchronize.incrementWithoutSynchronize();
        IncrementWithSynchronize.incrementWithSynchronize();
        ProducerConsumerProblemWIthQueue.problemWIthQueue();
        AtomicSynchronize.IncrementAtomicInteger();
    }
}
