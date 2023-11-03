package ua.dymohlo.geometricshapes;
/*
Class Triangle has to has 3 overloading area methods :
	area of triangle using Heron's formula
	area of triangle using the product of two sides per sine angle
	area using a base height product
*/

public class Triangle extends Figure {
    double sideA = 2;
    double sideB = 2;
    double sideC = 3;

    @Override
    public double perimeter() {
        double perimeter = sideA + sideB + sideC;
        return perimeter;
    }

    @Override
    public double area() {
        return 0.25 * Math.sqrt((sideA + sideB + sideC) * (sideB + sideC - sideA) * (sideA + sideC - sideB) * (sideA + sideB - sideC));
    }

    public double area(double sideA, double sideB, double sin) {
        return 0.5 * sideA * sideB * sin;
    }

    public double area(double sideA, double height) {
        return 0.5 * sideA * height;
    }
}
