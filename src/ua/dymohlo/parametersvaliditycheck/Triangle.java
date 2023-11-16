package ua.dymohlo.parametersvaliditycheck;

public class Triangle extends Figure {
    private double sideA;
    private double sideB;
    private double sideC;
    private double sin;
    private double height;

    public Triangle(double sideA, double sideB, double sideC, double sin) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.sin = sin;
    }

    public Triangle(double sideA, double height) {
        this.sideA = sideA;
        this.height = height;
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

    public double areaTwoSidesAndAngle() {
        return 0.5 * sideA * sideB * sin;
    }

    public double areaBaseAndHeight() {
        return 0.5 * sideA * height;
    }
}
