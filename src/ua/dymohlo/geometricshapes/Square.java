package ua.dymohlo.geometricshapes;

public class Square extends Figure {
    private double squareSide;

    public Square(double squareSide) {
        this.squareSide = squareSide;
    }

    @Override
    public double perimeter() {
        return squareSide * 4;
    }

    @Override
    public double area() {
        return squareSide * squareSide;
    }
}
