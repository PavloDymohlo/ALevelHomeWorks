public class Task3 {
    public static void main(String[] args) {

        int a = 1;
        int b = 2;
        System.out.println("Before changing the places of the variables: "+a+" ; "+b);

        int temp = a;
        a = b;
        b = temp;
        System.out.println("After changing the places of the variables: "+a+" ; "+b);
    }
}
