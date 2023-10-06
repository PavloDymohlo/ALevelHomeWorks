package ua.dymohlo.hw2;

import java.util.Scanner;

public class Hw2Task4 {
    public static void main(String[] args) {
       smallestNumber();
    }
    public static void smallestNumber(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first number:");
        int firstNumber = scan.nextInt();
        System.out.println("Enter second number:");
        int secondNumber = scan.nextInt();
        System.out.println("Enter third number:");
        int thirdNumber = scan.nextInt();

        String smallestNumber = Math.abs(firstNumber) < Math.abs(secondNumber) ?
                Math.abs(firstNumber) < Math.abs(thirdNumber) ? firstNumber +" is smallest" :
                        thirdNumber +" is smallest" : Math.abs(secondNumber) < Math.abs(thirdNumber) ?
                secondNumber + " is smallest" : thirdNumber + " is smallest";
        System.out.println(smallestNumber);
    }
}
