import java.util.Scanner;

public class Hw2Task2 {
    public static void main(String[] args) {
        //triangleArea();
        schoolAssistant();

    }
   /* public static void triangleArea(){
        int topAx, topAy, topBx, topBy, topCx, topCy;

        topAx = 1;
        topAy = 5;

        topBx = 3;
        topBy = 5;

        topCx = 6;
        topCy = 7;

        double triangleArea = (Math.abs(topAx * (topBy - topCy) + topBx * (topCy - topAy) + topCx * (topAy - topBy))) / 2;

        System.out.println(" The area of your triangle is " + triangleArea);
    }*/

    // нижще створимо калькулятор лінивого школяра.
    public static double triangleAreaFormula(int topAx, int topAy, int topBx, int topBy, int topCx, int topCy){

        int triangleArea = (Math.abs(topAx * (topBy - topCy) + topBx * (topCy - topAy) + topCx * (topAy - topBy))) / 2;

        return triangleArea;
    }

    public static void schoolAssistant(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть координати вершини A. Спочатку по осі абсцис(х), потім по осі ординат(у): ");
        int ax = scan.nextInt();
        int ay = scan.nextInt();
        System.out.println("Введіть координати вершини B. Спочатку по осі абсцис(х), потім по осі ординат(у): ");
        int bx = scan.nextInt();
        int by = scan.nextInt();
        System.out.println("Введіть координати вершини C. Спочатку по осі абсцис(х), потім по осі ординат(у): ");
        int cx = scan.nextInt();
        int cy = scan.nextInt();
        double ourTriangleArea = triangleAreaFormula(ax,ay,bx,by,cx,cy);
        System.out.println("Площа вашого трикутника "+ourTriangleArea);
    }

}
