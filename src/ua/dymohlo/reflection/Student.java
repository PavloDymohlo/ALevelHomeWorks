package ua.dymohlo.reflection;
/*
Створіть клас Student з наступними полями і методом passExamSuccessfully:

private String firstName (ім'я студента)
private String lastName (прізвище студента)
private int age (вік студента)
private int examScore (оцінка за екзамен)
    private void passExamSuccessfully() {
        this.examScore = 100;
    }
    */

public class Student {
    @ShowInfo
    private String firstName;
    @ShowInfo

    private String lastName;
    @ShowInfo

    private int age;
    private int examScore;

    public Student(String firstName, String lastName, int age, int examScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.examScore = examScore;
    }

    private void passExamSuccessfully() {
        this.examScore = 100;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExamScore() {
        return examScore;
    }

    public void setExamScore(int examScore) {
        this.examScore = examScore;
    }
}
