package ua.dymohlo.hw3;
/*
Подсчитать количество слов в строке
• Вводится строка, состоящая из слов, разделенных пробелами. Требуется посчитать количество
слов в ней
 */

import java.util.Scanner;
import java.util.StringTokenizer;

public class Task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your sentence: ");
        String input = scan.nextLine();
        System.out.println("You entered " + wordCount(input) + " words");

    }

    public static int wordCount(String text) {
        if (text == null) {
            return 0;
        }
        text = text.replaceAll("^\\P{L}+|\\P{L}+$", "");
        return text.isEmpty() ? 0 : text.split("\\P{L}+").length;
    }
}
