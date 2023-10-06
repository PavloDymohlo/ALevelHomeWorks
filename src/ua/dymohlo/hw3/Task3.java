package ua.dymohlo.hw3;
/*
Подсчитать количество слов в строке
• Вводится строка, состоящая из слов, разделенных пробелами. Требуется посчитать количество
слов в ней
 */

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your sentence: ");
        String input = scan.nextLine();
        System.out.println("You entered " + wordCount(input) + " words");

    }

    public static int wordCount(String text) {
        int counter = 0;
        if (text.length() != 0) {
            counter++;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ' ') {
                    counter++;
                }
            }
        }
        return counter;
    }
}
