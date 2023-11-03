package ua.dymohlo.geometricshapes;

public class Square extends Figure {
    double squareSide = 5;

    @Override
    public double perimeter() {
        return squareSide * 4;
    }

    @Override
    public double area() {
        return squareSide * squareSide;
    }
}
