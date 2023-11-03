package ua.dymohlo.geometricshapes;
/*
- Create class Figure with the following methods:
double perimeter();
double area();
- Create the following inheritors : Circle, Square, Triangle
- Class Triangle has to has 3 overloading area methods :
	area of triangle using Heron's formula
	area of triangle using the product of two sides per sine angle
	area using a base height product
*/

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Figure circle = new Circle();
        Figure square = new Square();
        Circle circle1 = new Circle();
        System.out.println("Perimeter of a circle is " + (circle.perimeter()));
        System.out.println("Area of a circle is " + (circle.area()));
        System.out.println("Perimeter of a square is " + (square.perimeter()));
        System.out.println("Area of a square is " + (square.area()));
        System.out.println("Perimeter of a triangle is " + (triangle.perimeter()));
        System.out.println("Area of a triangle found by Heron's formula is " + (triangle.area()));
        System.out.println("Area of a triangle found by the product of two sides and the angle between them is " +
                (triangle.area(2, 3, 0.67)));
        System.out.println("Area of a triangle found by a base height product is " + (triangle.area(3, 1.3)));
    }
}
