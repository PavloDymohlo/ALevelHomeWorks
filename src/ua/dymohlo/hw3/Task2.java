package ua.dymohlo.hw3;

import java.util.Scanner;

public class Task2 {
    /*
 Удалить из строки пробелы и определить, является ли она перевертышем (палиндромом)
• Считать строку из консоли.
• Передать в метод, который удалит из нее все пробелы.
• Передать строку без пробелов в метод, который определит, является ли она палиндромом
(перевертышем), т.е. одинаково пишется как с начала, так и с конца.
• Вывести результат в main()
*/
    public static void main(String[] args) {
        System.out.println("Enter your text: ");
        Scanner scan = new Scanner(System.in); //  pull up if i pull up
        String sentence = scan.nextLine();
        System.out.println(palindrome(sentence));

    }

    public static String withoutSpaces(String initialText) {
        String text = initialText.replaceAll(" ", "");
        return text;
    }

    public static boolean palindrome(String line) {
        String withoutSpaces = withoutSpaces(line);
        StringBuilder lineRevers = new StringBuilder(withoutSpaces);
        lineRevers.reverse();
        String change = lineRevers.toString();
        if (withoutSpaces.equalsIgnoreCase(change)) {
            System.out.println("Your text is a palindrome.");
        } else {
            System.out.println("Your text is not a palindrome.");
        }
        return withoutSpaces.equalsIgnoreCase(change);
    }
}
