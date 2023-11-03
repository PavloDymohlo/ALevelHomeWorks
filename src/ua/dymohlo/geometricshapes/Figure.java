package ua.dymohlo.geometricshapes;

public abstract class Figure {
    double perimeter;
    double area;

    public Figure(double perimeter, double area) {
        this.perimeter = perimeter;
        this.area = area;
    }

    public Figure() {
    }

    public abstract double perimeter();

    public abstract double area();
}
