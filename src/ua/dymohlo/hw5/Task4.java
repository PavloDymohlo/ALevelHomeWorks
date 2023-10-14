package ua.dymohlo.hw5;
/*
4. Удаление из массива k-го элемента со сдвигом всех расположенных справа от него
элементов на одну позицию влево.
*Необходимо создать новый массив, в котором удаляется элемент и вернуть его из метода.
Изначальный массив не должен измениться
[1, 2, 3, 4] -> [1, 2, 4
*/

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Task4 {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        fillArray(numbers);
        deletingAnElement(numbers);
    }

    public static void fillArray(int[] setNumbers) {
        int fill = 0;
        for (int i = 0; i < setNumbers.length; i++) {
            setNumbers[i] = fill++;
        }
        System.out.println(Arrays.toString(setNumbers));
    }

    public static void deletingAnElement(int[] numbers) {
        int delete = 2;// number of th element which need to delete
        int[] shortened = new int[numbers.length - 1];
        int j = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == delete) {
                continue;
            }
            shortened[j++] = numbers[i];
        }
        System.out.println(Arrays.toString(shortened));
    }
}
