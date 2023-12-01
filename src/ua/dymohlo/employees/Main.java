package ua.dymohlo.employees;
/*
Read information from file input.txt
Results write to file output.txt

name : "name1"
secondName : "secondName1"
salary : 35
age : 30

name : "name2"
secondName : "secondName2"
salary : 36
age : 31

name : "name3"
secondName : "secondName3"
salary : 37
age : 32

name : "name4"
secondName : "secondName4"
salary : 38
age : 33

name : "name5"
secondName : "secondName5"
salary : 39
age : 34

+1.Print full name of any employee whose firstName starts with ‘A’.

+2.Sort employees based on firstName, for same firstName sort by salary.

+3.Print list of all employee with min salary

+4.Count total salary

5.Find the difference in salary between the youngest and the oldest employee
*/


import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        File fileIn = new File("C:\\Users\\DELL\\IdeaProjects\\HomeWorks\\src\\ua\\dymohlo\\employees\\input.txt\\");
        fileIn.createNewFile();
        System.out.println(readingDataForFile(fileIn));
        System.out.println(firstNameStartsA(readingDataForFile(fileIn)));
        System.out.println(sortByFirstNameAndSalary(readingDataForFile(fileIn)));
        System.out.println(employeeWithMinSalary(readingDataForFile(fileIn)));
        System.out.println(totalSalary(readingDataForFile(fileIn)));
        System.out.println(differenceSalaryYoungestAndOldestEmployee(readingDataForFile(fileIn)));

        outPutInFile(fileIn);
    }

    private static List<Employees> readingDataForFile(File file) throws IOException {
        List<Employees> readList = new ArrayList<>();

        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext()) {
                String employeesName = scan.nextLine().split(":")[1].trim().replaceAll("\"", "");
                String employeesLastName = scan.nextLine().split(":")[1].trim().replaceAll("\"", "");
                String employeesSalaryStr = scan.nextLine().split(":")[1].trim();
                int employeesSalary = Integer.parseInt(employeesSalaryStr);
                String employeesAgeStr = scan.nextLine().split(":")[1].trim();
                int employeesAge = Integer.parseInt(employeesAgeStr);

                Employees employee = new Employees(employeesName, employeesLastName, employeesSalary, employeesAge);
                readList.add(employee);

                if (scan.hasNext()) {
                    scan.nextLine();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Employees roger = new Employees("Rabbit", "Roger", 4, 2);
        readList.add(roger);
        return readList;
    }

    private static List<Employees> firstNameStartsA(List<Employees> list) {
        List<Employees> newList = list.stream().filter(e -> e.getName().startsWith("A"))
                .collect(Collectors.toList());
        return newList;
    }

    private static Set<Employees> sortByFirstNameAndSalary(List<Employees> list) {
        Comparator<Employees> lamdaComparator = Comparator.comparing(Employees::getName);
        Comparator<Employees> lamdaComparator2 = Comparator.comparing(Employees::getSalary);
        lamdaComparator.thenComparing(lamdaComparator2);
        Set<Employees> list2 = new TreeSet<>(lamdaComparator);
        list2.addAll(list);
        return list2;
    }

    private static List<Employees> employeeWithMinSalary(List<Employees> list) {
        int minSalary = list.stream().min(Comparator.comparingInt(Employees::getSalary)).get().getSalary();
        return list.stream()
                .filter(employees -> employees.getSalary() == minSalary)
                .collect(Collectors.toList());
    }

    private static int totalSalary(List<Employees> list) {
        return list.stream().mapToInt(Employees::getSalary).sum();
    }

    private static int differenceSalaryYoungestAndOldestEmployee(List<Employees> list) {
        Comparator<Employees> ageComparator = ((o1, o2) -> o1.getAge() - o2.getAge());
        Employees minAge = list.stream().min(ageComparator).get();
        Employees maxAge = list.stream().max(ageComparator).get();

        return Math.abs(minAge.getSalary() - maxAge.getSalary());
    }

    private static void outPutInFile(File file) throws IOException {
        File fileOut = new File("C:\\Users\\DELL\\IdeaProjects\\HomeWorks\\src\\ua\\dymohlo\\employees\\output.txt");
        fileOut.createNewFile();

        RandomAccessFile randomAccessFile = new RandomAccessFile(fileOut, "rw");
        randomAccessFile.writeBytes(readingDataForFile(file).toString() + "\n");
        randomAccessFile.writeBytes(firstNameStartsA(readingDataForFile(file)).toString() + "\n");
        randomAccessFile.writeBytes(sortByFirstNameAndSalary(readingDataForFile(file)).toString() + "\n");
        randomAccessFile.writeBytes(employeeWithMinSalary(readingDataForFile(file)).toString() + "\n");
        randomAccessFile.writeBytes(String.valueOf(totalSalary(readingDataForFile(file))) + "\n");
        randomAccessFile.writeBytes(String.valueOf(differenceSalaryYoungestAndOldestEmployee(readingDataForFile(file))));
        randomAccessFile.close();
    }
}

