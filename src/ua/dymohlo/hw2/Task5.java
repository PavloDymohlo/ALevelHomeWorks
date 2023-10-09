package ua.dymohlo.hw2;

import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your number");
        String number = scan.nextLine();

        String change = "";
        for (int i = number.length(); i-- > 0; ) {
            change += number.charAt(i);
            System.out.print(number.charAt(i));
        }
        System.out.println();
        System.out.println("we can use this number " + change);
    }
}
