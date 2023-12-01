package ua.dymohlo.employees;

public class Employees {

    private String name;
    private String secondName;
    private int salary;
    private int age;

    public Employees(String name, String secondName, int salary, int age) {
        this.name = name;
        this.secondName = secondName;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return name + " " + secondName + "- salary is:  " + salary + ", age is: " + age;
    }
}
