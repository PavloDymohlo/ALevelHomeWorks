package ua.dymohlo.arraylist;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter numbers of element");
        int size = scan.nextInt();
        ArrayList<Integer> list = new ArrayList<>(size);
        arrayFilling(list, scan, size);
        arrayFillingByIndex(list, scan);
        elementIndex(list, scan);
        isContains(list, scan);
        getElement(list, scan);
        removeElement(list, scan);
    }

    private static void arrayFilling(ArrayList<Integer> list, Scanner scan, int size) {
        //System.out.println("fill your array ");
        System.out.println("Enter " + size + " numbers by a space");
        while (size-- > 0) {
            list.add(scan.nextInt());
        }
        System.out.println(list);
    }

    private static void arrayFillingByIndex(ArrayList<Integer> list, Scanner scan) {
        System.out.println("Enter the element you want to add, then the desired index");
        int element = scan.nextInt();
        int index = scan.nextInt();
        list.add(element, index);
        System.out.println("Your list after adding a new element: " + list);
    }

    private static void elementIndex(ArrayList<Integer> list, Scanner scan) {
        System.out.println("Enter the element whose index you want to find:");
        int element = scan.nextInt();
        list.indexOf(element);
        String result = (list.indexOf(element) >= 0) ? "Index of your element is " + list.indexOf(element) : "Sorry, but element is not listed!";
        System.out.println(result);
    }

    private static void isContains(ArrayList<Integer> list, Scanner scan) {
        System.out.println("Enter the element whose availability you want to know: ");
        int element = scan.nextInt();
        list.isContains(element);
        String result = (list.isContains(element)) ? "Yes, your element is listed! " : "Sorry, but element is not listed!";
        System.out.println(result);
    }

    private static void getElement(ArrayList<Integer> list, Scanner scan) {
        System.out.println("Enter the index of the element you want to retrieve:");
        int index = scan.nextInt();
        System.out.println("Element of this index is: " + list.get(index));
    }

    private static void removeElement(ArrayList<Integer> list, Scanner scan) {
        System.out.println("Enter the index of element you want to delete: ");
        int index = scan.nextInt();
        System.out.println("Number " + list.remove(index) + " was deleted!");
    }
}
