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

    int x;
    int y;
    int z;

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void main(String[] args) {
        Vector vectorA = new Vector(5, 6, 7);
        int[] vectors = new int[5];
        System.out.println(vectorA.vectorLength());
        System.out.println(vectorA.vectorMultiplication());
        System.out.println(vectorA.cosineBetweenVectors());
        System.out.println(vectorA.sumVector());
        System.out.println(vectorA.difVector());
        System.out.println(Arrays.toString(vectors(5)));
    }

    public double vectorLength() {
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }

    public double vectorMultiplication() {
        Vector vectorB = new Vector(2, 1, 4);
        return Math.sqrt((x * x) + (y * y) + (z * z)) * Math.sqrt((vectorB.x * vectorB.x) + (vectorB.y * vectorB.y)
                + (vectorB.z * vectorB.z));
    }

    public double cosineBetweenVectors() {
        Vector vectorB = new Vector(2, 1, 4);
        return (x * vectorB.x + y * vectorB.y + z * vectorB.z) / (Math.sqrt((x * x) + (y * y) + (z * z)) *
                Math.sqrt((vectorB.x * vectorB.x) + (vectorB.y * vectorB.y) + (vectorB.z * vectorB.z)));
    }

    public double sumVector() {
        Vector vectorB = new Vector(2, 1, 4);
        return (Math.sqrt((x * x) + (y * y) + (z * z))) + (Math.sqrt((vectorB.x * vectorB.x) +
                (vectorB.y * vectorB.y) + (vectorB.z * vectorB.z)));
    }

    public double difVector() {
        Vector vectorB = new Vector(2, 1, 4);
        return (Math.sqrt((x * x) + (y * y) + (z * z))) - (Math.sqrt((vectorB.x * vectorB.x) +
                (vectorB.y * vectorB.y) + (vectorB.z * vectorB.z)));
    }

    public static int[] vectors(int n) {
        int[] randVectors = new int[n];
        for (int i = 0; i < randVectors.length; i++) {
            randVectors[i] = ThreadLocalRandom.current().nextInt(1, 100);
        }
        return randVectors;
    }
}
