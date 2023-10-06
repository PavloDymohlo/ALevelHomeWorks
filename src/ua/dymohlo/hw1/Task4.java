package ua.dymohlo.hw1;

public class Task4 {
    public static void main(String[] args) {
        firstWay();
        System.out.println();
        secondWay();
    }

    public static void firstWay(){
        int a = 5;
        int b = 3;
        System.out.println("Before changing the places of the variables: "+a+" ; "+b);

        a = a-b; //2
        b = a+b; //5
        a = b-a; //3
        System.out.println("After changing the places of the variables: "+a+" ; "+b);
    }

    public static void secondWay(){
        int a = 5;
        int b = 3;
        System.out.println("Before changing the places of the variables: "+a+" ; "+b);

        a = a^b; //6
        b = a^b; //3
        a = a^b; //5
        System.out.println("After changing the places of the variables: "+a+" ; "+b);

    }
}
