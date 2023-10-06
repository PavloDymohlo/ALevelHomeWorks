package ua.dymohlo.hw3;

import java.util.Scanner;

/*
Программа "Угадай число"
Задача
Отгадать целое число, которое "загадал" компьютер в определенном диапазоне.

Решение
Описание переменных:

a – число, "загаданное" компьютером;
b – очередное число, вводимое пользователем.
*/
public class Task4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your number from 0 to 10.");
        int input = scan.nextInt();
        System.out.println("Congratulation! You found the secret number " + guessTheNumber(input));

    }

    public static int guessTheNumber(int a) {
        Scanner scan = new Scanner(System.in);
        int rand = (int) (Math.random() * 10);
        int number = a;
        while (number != rand) {
            if (number < rand) {
                System.out.println("No, you need a bigger number. Try again!");
                number = scan.nextInt();
            } else if (number > rand) {
                System.out.println("No, you need a smaller number. Try again!");
                number = scan.nextInt();
            }
        }
        return number;
    }
}