import java.util.Scanner;

public class HwTask5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your number");
        String number = scan.nextLine();

        for(int i = number.length()-1; i >= 0; i-- ){
            System.out.print(number.charAt(i));
        }
    }
}