package ua.dymohlo.hw2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first number:");
        int firstNumber = scan.nextInt();
        System.out.println("Enter second number:");
        int secondNumber = scan.nextInt();
        System.out.println("Enter third number:");
        int thirdNumber = scan.nextInt();
        smallestNumber(firstNumber, secondNumber, thirdNumber);
    }

    public static void smallestNumber(int firstNumber, int secondNumber, int thirdNumber) {

        int first = (firstNumber < 0) ? -firstNumber : firstNumber;
        int second = (secondNumber < 0) ? -secondNumber : secondNumber;
        int third = (thirdNumber < 0) ? -thirdNumber : thirdNumber;

        int min = Math.min(Math.min(first, second), third);
        if (min == first) {
            System.out.println("the smallest number is " + firstNumber);
        } else if (min == second) {
            System.out.println("the smallest number is " + secondNumber);
        } else if (min == third) {
            System.out.println("the smallest number is " + thirdNumber);
        }
    }
}
