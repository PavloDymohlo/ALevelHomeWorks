package ua.dymohlo.sortinggeometricfigures;

public class Circle extends Figure {
    private double rad;

    public Circle(double rad) {
        this.rad = rad;
    }

    @Override
    public double perimeter() {
        return Math.PI * 2 * rad;
    }

    @Override
    public double area() {
        return Math.PI * (Math.pow(rad, 2));
        //return  rad*rad;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "rad=" + rad +
                '}';
    }
}