package ua.dymohlo.geometricshapes;

public class Circle extends Figure {
    double rad = 8.5;

    @Override
    public double perimeter() {
        return 2 * 3.14 * rad;
    }

    @Override
    public double area() {
        return 3.14 * (Math.pow(rad, 2));
    }
}
