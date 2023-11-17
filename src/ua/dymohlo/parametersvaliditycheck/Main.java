package ua.dymohlo.parametersvaliditycheck;
/*
Add parameters validity check into Figure HW
If parameters are not valid (negative or zero value, non existence triangle) you should throw custom exceptions
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        squareParametersValidityCheck();
        circleParametersValidityCheck();
        triangleParametersValidityCheck();
    }

    private static void squareParametersValidityCheck() {
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
            } catch (InvalidValuesException e) {
                e.printStackTrace();
                System.out.println("Enter another value");
            }
        }
    }

    private static void circleParametersValidityCheck() {
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
                }
            } catch (InvalidValuesException e) {
                e.printStackTrace();
                System.out.println("Enter another value");
            }
        }
    }

    private static void triangleParametersValidityCheck() {
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
