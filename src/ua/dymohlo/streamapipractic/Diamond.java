package ua.dymohlo.streamapipractic;

public class Diamond extends Figure {
    private double firstDiagonal;
    private double secondDiagonal;
    private double side;

    public Diamond(double firstDiagonal, double secondDiagonal, double side) {
        this.firstDiagonal = firstDiagonal;
        this.secondDiagonal = secondDiagonal;
        this.side = side;
    }

    @Override
    public double perimeter() {
        return 4 * side;
    }

    @Override
    public double area() {
        return 0.5 * firstDiagonal * secondDiagonal;
    }

    @Override
    public String toString() {
        return "Diamond{" +
                "firstDiagonal=" + firstDiagonal +
                ", secondDiagonal=" + secondDiagonal +
                ", side=" + side +
                '}';
    }
}
