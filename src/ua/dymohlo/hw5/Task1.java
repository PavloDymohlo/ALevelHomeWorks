package ua.dymohlo.hw5;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/*
1. Заполнение двумерного массива значениями индекса (от 1 и до кол-ва элементов в
массиве), при этом каждая вторая строка - отрицательными значениями.
Например
1 2 3
-4 -5 -6
7 8 9
-10 -11 -12
*Передать массив в метод, заполнить данный массив
*/
public class Task1 {
    public static void main(String[] args) {
        int[][] doubleArray = new int[4][3];
        fillAndChange(doubleArray);
        System.out.println();
        printArray(doubleArray);
    }

    public static void fillAndChange(int[][] setNumbers) {
        int fill = 1;
        for (int i = 0; i < setNumbers.length; i++) {
            for (int j = 0; j < setNumbers[i].length; j++) {
                setNumbers[i][j] = fill++;
            }
            System.out.println(Arrays.toString(setNumbers[i]));
        }
        int[][] newSetNumbers = new int[setNumbers.length][setNumbers.length];
        for (int i = 0; i < setNumbers.length; i++) {
            for (int j = 0; j < setNumbers[i].length; j++) {
                newSetNumbers[i] = setNumbers[i];
                if (i % 2 != 0) {
                    newSetNumbers[i][j] *= (-1);
                }
            }
        }
    }

    public static void printArray(int[][] set) {
        for (int i = 0; i < set.length; i++) {
            System.out.println(Arrays.toString(set[i]));
        }
    }
}
