package ua.dymohlo.multithreadingcontinue;

public class Main {
    public static void main(String[] args) {
        AtomicSynchronize.IncrementAtomicInteger();
        IncrementWithoutSynchronize.incrementWithoutSynchronize();
        IncrementWithSynchronize.incrementWithSynchronize();
        ProducerConsumerProblemWIthQueue.problemWIthQueue();
    }
}
