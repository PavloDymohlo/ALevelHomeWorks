package ua.dymohlo.multithreadingcontinue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class ProducerConsumerProblemWIthQueue {
    public static final BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(5);

    public static void problemWIthQueue() {
        Thread producer = new Thread(() -> {
            while (true) {
                produce();
            }
        });

        Thread consumer = new Thread(() -> {
            while (true) {
                consumer();
            }
        });

        producer.start();
        consumer.start();
    }

    private static void produce() {
        int randomInt = ThreadLocalRandom.current().nextInt(100);
        System.out.println("Producer " + randomInt);
        try {
            buffer.put(randomInt);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void consumer() {
        Integer take;
        try {
            take = buffer.take();
            System.out.println("Consumer " + take);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
