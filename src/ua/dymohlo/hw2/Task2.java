package ua.dymohlo.hw2;

public class Task2 {
    public static void main(String[] args) {
        int topAx, topAy, topBx, topBy, topCx, topCy;

        topAx = 1;
        topAy = 5;

        topBx = 3;
        topBy = 5;

        topCx = 6;
        topCy = 7;
        triangleArea(topAx, topAy, topBx, topBy, topCx, topCy);
    }

    public static void triangleArea(int topAx, int topAy, int topBx, int topBy, int topCx, int topCy) {

        double area = (Math.abs(topAx * (topBy - topCy) + topBx * (topCy - topAy) + topCx * (topAy - topBy))) / 2;
        System.out.println(" The area of your triangle is " + area);
    }
}
