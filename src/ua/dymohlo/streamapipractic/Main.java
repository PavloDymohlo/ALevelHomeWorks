package ua.dymohlo.streamapipractic;

import java.util.*;
import java.util.stream.Collectors;

/*
1.За допомогою Stream API знайти фігуру, площа якої більша за мінімальну на заданий параметр

private Figure findFigure(double difference)

2. За допомогою Stream API знайти фігуру у якої площа у два рази більша за периметер
*/
public class Main {
    public static void main(String[] args) {
        Figure triangle = new Triangle(40, 40, 60);
        Figure circle = new Circle(10);
        Figure square = new Square(8);
        Figure diamond = new Diamond(12, 13, 17);
        List<Figure> figure = new ArrayList<>(Arrays.asList(triangle, circle, square, diamond));
        double diff = 14;
        System.out.println("Perimeter of a circle is " + (circle.perimeter()));
        System.out.println("Area of a circle is " + (circle.area()));
        System.out.println();
        System.out.println("Perimeter of a square is " + (square.perimeter()));
        System.out.println("Area of a square is " + (square.area()));
        System.out.println();
        System.out.println("Perimeter of a triangle is " + (triangle.perimeter()));
        System.out.println("Area of a triangle found by Heron's formula is " + (triangle.area()));
        System.out.println();
        System.out.println("Perimeter of a diamond is " + (diamond.perimeter()));
        System.out.println("Area of a diamond found by Heron's formula is " + (diamond.area()));
        System.out.println();

        System.out.println(figureWithAreaTwicePerimeter(figure));
        System.out.println(findFigureLargeMin(figure, diff));
    }

    private static List<Figure> findFigureLargeMin(List<Figure> figures, double dif) {
        return figures.stream()
                .filter(figure -> figure.area() == findMinFigure(figures).area() + dif)
                .collect(Collectors.toList());
    }

    private static Figure findMinFigure(List<Figure> figures) {
        Figure figureMin = figures.stream()
                .min(Comparator.comparingDouble(Figure::area))
                .get();
        return figureMin;
    }

    private static List<Figure> figureWithAreaTwicePerimeter(List<Figure> figures) {
        return figures.stream()
                .filter(figure -> figure.area() == figure.perimeter() * 2)
                .collect(Collectors.toList());
    }
}