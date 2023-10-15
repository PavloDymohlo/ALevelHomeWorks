package ua.dymohlo.hw4;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/*
• Заполнить одномерный массив случайными целочисленными значениями.
• Все четные значения заменить на нули. Размер массива - 2000 элементов.
*/
public class Task3 {
    public static void main(String[] args) {
        int[] setNumbers = new int[2000];
        randomNumbers(setNumbers);
        System.out.println("zero instead of even values " + Arrays.toString(evenValueToZero(setNumbers)));
    }

    public static void randomNumbers(int[] set) {
        for (int i = 0; i < set.length; i++) {
            set[i] = ThreadLocalRandom.current().nextInt(1, 10);
        }

        System.out.println("Your 2000 random values: " + Arrays.toString(set));
    }

    public static int[] evenValueToZero(int[] set) {
        int[] newSet = new int[set.length];
        for (int i = 0; i < set.length; i++) {
            newSet[i] = set[i];
        }
        for (int i = 0; i < newSet.length; i++) {
            int validation = newSet[i] % 2;
            if (validation == 0) {
                newSet[i] = 0;
            }
        }
        return newSet;
    }
}
