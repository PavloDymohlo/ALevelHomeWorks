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
        evenValueToZero(setNumbers);

    }

    public static void randomNumbers(int[] set) {
        for (int i = 0; i < set.length; i++) {
            set[i] = ThreadLocalRandom.current().nextInt(1, 10);
        }

        System.out.println("Your 2000 random values: " + Arrays.toString(set));
    }

    public static void evenValueToZero(int[] set) {
        for (int i = 0; i < set.length; i++) {
            int validation = set[i] % 2;
            if (validation == 0) {
                set[i] = 0;
            }
        }
        System.out.println("in next line, all even value changed to zero.");
        System.out.println(Arrays.toString(set));
    }
}
