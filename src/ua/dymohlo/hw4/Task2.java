package ua.dymohlo.hw4;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/*
• Заполнить одномерный массив случайными целочисленными значениями.
• Проверить сколько простых чисел присутствует в массиве. Размер массива 1000 элементов.
*/

public class Task2 {
    public static void main(String[] args) {
        int[] setNumbers = new int[1000];
        randomNumbers(setNumbers);
        System.out.println(findPrime(setNumbers) + " primes numbers are in this array.");
    }

    public static void randomNumbers(int[] setRandom) {
        for (int i = 0; i < setRandom.length; i++) {
            setRandom[i] = ThreadLocalRandom.current().nextInt(1, 10);
        }
        System.out.println("Your set of random numbers " + Arrays.toString(setRandom));
    }

    public static boolean isPrime(int number) {
        boolean prime = true;
        if (number <2) {
            prime = false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                prime = false;
            }
        }
        return prime;
    }

    public static int findPrime(int[] set) {
        int counter = 0;
        for (int i = 0; i < set.length; i++) {
            if (isPrime(set[i])) {
                counter++;
            }
        }
        return counter;
    }
}
