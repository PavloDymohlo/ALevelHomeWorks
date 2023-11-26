package ua.dymohlo.streamapipractic;

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
    }

    @Override
    public String toString() {
        return "Circle{" +
                "rad=" + rad +
                '}';
    }
}
