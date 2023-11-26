package ua.dymohlo.sortinggeometricfigures;

/*
Додати до фігур можливість їх сортування. (Collections.sort(Comparator))
Порівнювати фігури треба спочатку за площею потім за периметром, для цього створити ланцюг компораторів
Компоратори реалізувати за допомогою лямбда виразів
*/

import java.util.*;

public class Main {
    public static void main(String[] args) {
        figureSort(squareParametersValidityCheck(), circleParametersValidityCheck(), triangleParametersValidityCheck());

    }

    private static void figureSort(Figure square, Figure circle, Figure triangle) {
        Comparator<Figure> areaComparator = (Figure o1, Figure o2) -> (int) (o1.area() - o2.area());
        Comparator<Figure> perimeterComparator = (Figure o1, Figure o2) -> (int) (o1.perimeter() - o2.perimeter());
        areaComparator.thenComparing(perimeterComparator);
        List<Figure> figure = new ArrayList<>();
        figure.add(circle);
        figure.add(square);
        figure.add(triangle);
        Collections.sort(figure, areaComparator);

        System.out.println("Your figures are sorted in the following order: " + figure);
    }

    private static Figure squareParametersValidityCheck() {
        double side = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the length of the side of the square: ");
        while (side <= 0) {
            try {
                side = scan.nextDouble();
                if (side <= 0) {
                    throw new InvalidValuesException("Such a square does not exist!");
                }
                Figure square = new Square(side);
                System.out.println("Perimeter of a square is " + (square.perimeter()));
                System.out.println("Area of a square is " + (square.area()));
                return square;
            } catch (InvalidValuesException e) {
                e.printStackTrace();
                System.out.println("Enter another value");
            }
        }
        Figure square = new Square(side);
        return square;
    }

    private static Figure circleParametersValidityCheck() {
        double rad = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the radius of circle:");
        while (rad <= 0) {
            try {
                rad = scan.nextDouble();
                if (rad <= 0) {
                    throw new InvalidValuesException("The radius of the circle must be positive!");
                } else {
                    Figure circle = new Circle(rad);
                    System.out.println("Perimeter of a circle is " + (circle.perimeter()));
                    System.out.println("Area of a circle is " + (circle.area()));
                    return circle;
                }
            } catch (InvalidValuesException e) {
                e.printStackTrace();
                System.out.println("Enter another value");
            }
        }
        Figure circle = new Circle(rad);
        return circle;
    }

    private static Figure triangleParametersValidityCheck() {
        Scanner scan = new Scanner(System.in);
        double sideA = inputValue(scan, "Enter the length of side A:", "Such a triangle does not exist!");
        double sideB = inputValue(scan, "Enter the length of side B:", "Such a triangle does not exist!");
        double sideC = inputValue(scan, "Enter the length of side C:", "Such a triangle does not exist!");
        double sin = inputValue(scan, "Enter the sine of the angle between the sides A and B: ", "The sine of the angle cannot be zero or have a negative value!");
        float height = (float) inputValue(scan, "Enter the height of the triangle: ", "The height of the triangle must be greater than zero!");

        Triangle triangle = new Triangle(sideA, sideB, sideC);
        double twoSidesAndTheAngle = triangle.area(sin);
        double baseHeightProduct = triangle.area(height);
        System.out.println("Perimeter of a triangle is " + (triangle.perimeter()));
        System.out.println("Area of a triangle found by Heron's formula is " + (triangle.area()));
        System.out.println("Area of a triangle found by the product of two sides and the angle between them is " + twoSidesAndTheAngle);
        System.out.println("Area of a triangle found by a base height product is " + baseHeightProduct);
        return triangle;
    }


    private static double inputValue(Scanner scan, String task, String errorText) {
        try {
            System.out.println(task);
            double result = scan.nextDouble();
            if (result <= 0) {
                throw new InvalidValuesException(errorText);
            }
            return result;
        } catch (InvalidValuesException e) {
            e.printStackTrace();
            System.out.println("Enter another value");
            return inputValue(scan, task, errorText);
        }
    }
}
