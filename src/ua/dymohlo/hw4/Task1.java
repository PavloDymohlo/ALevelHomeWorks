package ua.dymohlo.hw4;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/*
- Заполнить одномерный массив случайными целочисленными значениями. 400 элементов.
- Найти среднее арифметическое массива.
- среднее геометрическое элементов массива.
P.S. значения элементов можно ограничить значениями 1-10 включительно.
*/
public class Task1 {
    public static void main(String[] args) {
        int[] setNumbers = new int[400];
        randomNumbers(setNumbers);
        System.out.println(arithmeticAverage(setNumbers) + " is the arithmetic average of random numbers");
        System.out.println(geometricAverage(setNumbers) + " is the geometric average of random numbers");
    }

    public static void randomNumbers(int[] setRandom) {
        for (int i = 0; i < setRandom.length; i++) {
            setRandom[i] = ThreadLocalRandom.current().nextInt(1, 10);
        }
        System.out.println("Your set of random numbers " + Arrays.toString(setRandom));
    }

    public static double arithmeticAverage(int[] setArithmetic) {
        double average = 0;
        double sum = 0;
        for (int i = 0; i < setArithmetic.length; i++) {
            sum += setArithmetic[i];
        }
        average = sum / setArithmetic.length;
        return average;
    }

    public static double geometricAverage(int[] setGeometric) {
        double average = 0;
        double multiplication = 1;
        for (int i = 0; i < setGeometric.length; i++) {
            multiplication *= setGeometric[i];
        }
        average = Math.pow(multiplication, (double) 1 / setGeometric.length);
        return average;
    }
}
