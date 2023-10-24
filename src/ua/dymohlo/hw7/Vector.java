package ua.dymohlo.hw7;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/*
Создайте класс, который описывает вектор (в трёхмерном пространстве).
У него должны быть:
а) конструктор с параметрами в виде списка координат x, y, z
б) метод, вычисляющий длину вектора. Корень можно посчитать с помощью Math.sqrt():
в) метод, вычисляющий векторное произведение с другим вектором
г) метод, вычисляющий косинус угла между векторами: косинус угла между векторами
равен скалярному произведению векторов, деленному на произведение модулей (длин)
векторов;
д) методы для суммы и разности векторов
е) статический метод, который принимает целое число n, и возвращает массив случайных
векторов размером n.
*Если метод возвращает вектор, то он должен возвращать новый объект, а не менять
базовый.
*/
public class Vector {

    double x;
    double y;
    double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void main(String[] args) {
        Vector vectorA = new Vector(5, 6, 7);
        Vector vectorB = new Vector(1, 3, 4);
        Vector[] vectors = new Vector[3];
        System.out.println("Vector's length is: " + vectorA.vectorLength());
        System.out.println("Vector product of two vectors is: " + vectorA.vectorMultiplication(vectorB));
        System.out.println("cosine of the angle is; " + vectorA.cosineBetweenVectors(vectorB));
        System.out.println("The sum of vectors is: " + vectorA.sumVector(vectorB));
        System.out.println("The different of vectors is: " + vectorA.difVector(vectorB));
        System.out.println("New vectors are: " + Arrays.toString(vectors(3)));
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public double vectorLength() {
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }

    public Vector vectorMultiplication(Vector vectorB) {
        double pointX = y * vectorB.z - z * vectorB.y;
        double pointY = z * vectorB.x - x * vectorB.z;
        double pointZ = x * vectorB.y - y * vectorB.x;
        return new Vector(pointX, pointY, pointZ);
    }

    public double cosineBetweenVectors(Vector vectorB) {
        return (x * vectorB.x + y * vectorB.y + z * vectorB.z) / (Math.sqrt((x * x) + (y * y) + (z * z)) *
                Math.sqrt((vectorB.x * vectorB.x) + (vectorB.y * vectorB.y) + (vectorB.z * vectorB.z)));
    }

    public Vector sumVector(Vector vectorB) {
        return new Vector(x + vectorB.x, y + vectorB.y, z + vectorB.z);
    }

    public Vector difVector(Vector vectorB) {
        return new Vector(x - vectorB.x, y - vectorB.y, z - vectorB.z);
    }

    public static Vector[] vectors(int n) {
        Vector[] vectorC = new Vector[n];
        for (int i = 0; i < vectorC.length; i++) {
            double pointA = ThreadLocalRandom.current().nextDouble(1, 10);
            double pointB = ThreadLocalRandom.current().nextDouble(1, 10);
            double pointC = ThreadLocalRandom.current().nextDouble(1, 10);
            vectorC[i] = new Vector(pointA, pointB, pointC);
        }
        return vectorC;
    }
}
