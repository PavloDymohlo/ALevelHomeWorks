import java.util.Scanner;

public class Hw2Task2 {
    public static void main(String[] args) {
        triangleArea();
        //schoolAssistant();

    }
   public static void triangleArea(){
        int topAx, topAy, topBx, topBy, topCx, topCy;

        topAx = 1;
        topAy = 5;

        topBx = 3;
        topBy = 5;

        topCx = 6;
        topCy = 7;

        double triangleArea = (Math.abs(topAx * (topBy - topCy) + topBx * (topCy - topAy) + topCx * (topAy - topBy))) / 2;

        System.out.println(" The area of your triangle is " + triangleArea);
    }

    // нижще створимо калькулятор лінивого школяра( Для наглядності - тільки два способи пошуку площі трикутника
    /*public static double triangleAreaByPoint(int topAx, int topAy, int topBx, int topBy, int topCx, int topCy){
        return (Math.abs(topAx * (topBy - topCy) + topBx * (topCy - topAy) + topCx * (topAy - topBy))) / 2;
    }
    public static double triangleAreaBySide(double side, double height){
        return (side * height)/2;
    }
    public static void schoolAssistant(){
            Scanner scan = new Scanner(System.in);
            System.out.println("Для пошуку площі трикутника за координатами введіть 1, за стороною та висотою введіть 2 ");
            double choose = scan.nextDouble();
            if (choose == 1) {
                System.out.println("Введіть координати вершини A. Спочатку по осі абсцис(х), потім по осі ординат(у): ");
                int ax = scan.nextInt();
                int ay = scan.nextInt();
                System.out.println("Введіть координати вершини B. Спочатку по осі абсцис(х), потім по осі ординат(у): ");
                int bx = scan.nextInt();
                int by = scan.nextInt();
                System.out.println("Введіть координати вершини C. Спочатку по осі абсцис(х), потім по осі ординат(у): ");
                int cx = scan.nextInt();
                int cy = scan.nextInt();
                double ourTriangleArea = triangleAreaByPoint(ax, ay, bx, by, cx, cy);
                System.out.println("Площа вашого трикутника " + ourTriangleArea);
            } else if (choose == 2) {
                System.out.println("Введіть значення сторони трикутника: ");
                double side = scan.nextDouble();
                System.out.println("Введіть значення висоти трикутника: ");
                double height = scan.nextDouble();
                double ourTriangleArea = triangleAreaBySide(side, height);
                System.out.println("Площа вашого трикутника " + ourTriangleArea);
            } else {
                System.out.println("Такого варіанту не існує!");
            }
    }

     */
}
