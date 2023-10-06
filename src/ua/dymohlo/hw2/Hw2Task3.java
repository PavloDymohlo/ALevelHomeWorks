package ua.dymohlo.hw2;

import java.util.Scanner;

public class Hw2Task3 {
    public static void main(String[] args) {
        numberCheck();
    }
    public  static void numberCheck(){
        System.out.println(" Enter your number");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int result = number % 2;
        if(result == 1){
            System.out.println("Your number "+ number+ " is an odd number.");
        }
        else{
            System.out.println("Your number "+ number+" is an even number.");
        }
    }
}
