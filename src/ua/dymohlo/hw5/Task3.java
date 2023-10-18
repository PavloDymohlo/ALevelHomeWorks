package ua.dymohlo.hw5;
/*
3. Дан двумерный массив NxN(количество строк = количество столбцов), написать программу
которая поменяет местами столбцы и строки.
До   После
1 2   1 3
3 4   2 4

*Необходимо создать новый массив, в котором выполняются превращения и вернуть его из метода.
Изначальный массив не должен измениться
*/

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Task3 {
    public static void main(String[] args) {
        int[][] doubleArray = new int[3][3];
        fill(doubleArray);
        System.out.println();
        swappingRowsAndColumns(doubleArray);
        printArray(swappingRowsAndColumns(doubleArray));
    }

    public static void fill(int[][] setNumbers) {
        for (int i = 0; i < setNumbers.length; i++) {
            for (int j = 0; j < setNumbers.length; j++) {
                setNumbers[i][j] = ThreadLocalRandom.current().nextInt(1, 5);
            }
        }
        printArray(setNumbers);
    }

    public static void printArray(int[][] set) {
        for (int i = 0; i < set.length; i++) {
            System.out.println(Arrays.toString(set[i]));
        }
    }

    public static int[][] swappingRowsAndColumns(int[][] doubleSet) {
        int[][] swapping = new int[doubleSet[0].length][doubleSet.length];
        for (int i = 0; i < doubleSet.length; i++) {
            for (int j = 0; j < doubleSet.length; j++) {
                swapping[j][i] = doubleSet[i][j];
            }
        }
        return swapping;
    }
}
