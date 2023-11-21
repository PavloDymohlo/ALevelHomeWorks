package ua.dymohlo.sortinggeometricfigures;

public class Triangle extends Figure {
    private double sideA;
    private double sideB;
    private double sideC;
    private double sin;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double perimeter() {
        double perimeter = sideA + sideB + sideC;
        return perimeter;
    }

    @Override
    public double area() {
        double halfPerimeter = perimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }

    public double area(double sin) {
        return 0.5 * sideA * sideB * sin;
    }

    public double area(float height) {
        return 0.5 * sideA * height;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                ", sin=" + sin +
                '}';
    }
}