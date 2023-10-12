package ua.dymohlo.hw4;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/*
- Заполнить одномерный массив случайными целочисленными значениями. 400 элементов.
- Найти среднее арифметическое массива.
- среднее геометрическое элементов массива. Размер массива -  10 элементов(double)
P.S. значения элементов можно ограничить значениями 1-10 включительно.
*/
public class Task1 {
    public static void main(String[] args) {
        int[] setNumbers = new int[400];
        randomNumbers(setNumbers);
        arithmeticAverage(setNumbers);
        geometricAverage(setNumbers);
    }

    public static void randomNumbers(int[] setRandom) {
        for (int i = 0; i < setRandom.length; i++) {
            setRandom[i] = ThreadLocalRandom.current().nextInt(1, 10);
        }
        System.out.println("Your set of random numbers " + Arrays.toString(setRandom));
    }

    public static void arithmeticAverage(int[] setArithmetic) {
        double average = 0;
        double sum = 0;
        for (int i = 0; i < setArithmetic.length; i++) {
            sum += setArithmetic[i];
        }
        System.out.println("The arithmetic average of random numbers is: " + (average = sum / setArithmetic.length));
    }

    public static void geometricAverage(int[] setGeometric) {
        int[] numbers = Arrays.stream(setGeometric).limit(10).toArray();
        double average = 0;
        double multiplication = 1;
        for (int i = 0; i < numbers.length; i++) {
            multiplication *= numbers[i];
        }
        System.out.println("Numbers for the geometric average " + Arrays.toString(numbers));
        System.out.print("The geometric average of random numbers is: ");
        System.out.println(average = Math.sqrt(multiplication));
    }
}
