package ua.dymohlo.hw2;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your number");
        int number = scan.nextInt();
        numberCheck(number);
    }


    public static void numberCheck(int number) {

        int result = number % 2;
        if (result == 1) {
            System.out.println("Your number " + number + " is an odd number.");
        } else {
            System.out.println("Your number " + number + " is an even number.");
        }
    }
}
