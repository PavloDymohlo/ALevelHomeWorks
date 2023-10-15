package ua.dymohlo.hw5;
/*
2. Проверить, заданный массив на упорядоченность по убыванию, т. е. определить, верно ли,
что каждый его элемент, начиная со второго, не больше предыдущего.
*передать массив в метод, получить boolean
*/

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Task2 {
    public static void main(String[] args) {
        //int[] numbers = {9,8,7,6,5}; //for validation
        //System.out.println(Arrays.toString(numbers)); // for validation
        int[] numbers = new int[5];
        fillArray(numbers);
        String order = (orderOfNumbers(numbers)) ? "The array is sorted in descending order" :
                "The array is not sorted in descending order";
        System.out.println(order);
    }

    public static void fillArray(int[] setNumbers) {
        for (int i = 0; i < setNumbers.length; i++) {
            setNumbers[i] = ThreadLocalRandom.current().nextInt(1, 10);
        }
        System.out.println(Arrays.toString(setNumbers));
    }

    public static boolean orderOfNumbers(int[] set) {
        boolean order = true;
        for (int i = 0; i < set.length - 1; i++) {
            if (set[i + 1] >= set[i]) {
                order = false;
                break;
            }
        }
        return order;
    }

}

