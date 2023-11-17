package ua.dymohlo.geometricshapes;
/*
Class Triangle has to has 3 overloading area methods :
	area of triangle using Heron's formula
	area of triangle using the product of two sides per sine angle
	area using a base height product
*/

public class Triangle extends Figure {
    private double sideA;
    private double sideB;
    private double sideC;

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
        return 0.5 * (sideA * sideB * sin);
    }

    public double area(float height) {
        return 0.5 * sideA * height;
    }
}
