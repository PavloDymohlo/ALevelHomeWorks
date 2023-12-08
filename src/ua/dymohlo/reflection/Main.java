package ua.dymohlo.reflection;
/*Створіть клас Student з наступними полями і методом passExamSuccessfully:

private String firstName (ім'я студента)
private String lastName (прізвище студента)
private int age (вік студента)
private int examScore (оцінка за екзамен)
    private void passExamSuccessfully() {
        this.examScore = 100;
    }
Створіть анотацію @ShowInfo, яку можна ставити над полями. Ця анотація має вказувати, чи дозволено виводити дане поле в методі,
який виводитиме інформацію про об'єкт Student.
Для цього анотація має мати параметр boolean show зі значенням за замовчуванням true.

Створіть клас StudentInfoPrinter, який має наступний метод:

public void printStudentInfo(Student student)
Цей метод має використовувати рефлексію для виведення інформації про студента. Виводити повинніся лише ті поля,
які анотовані анотацією @ShowInfo з параметром show=true. Інформація повинна виводитися в форматі:

Ім'я: {ім'я студента}
Прізвище: {прізвище студента}
Вік: {вік студента}

Створіть об'єкт класу `Student`, ініціалізуйте його поля та встановіть анотації `@ShowInfo` для деяких полів.
Створіть об'єкт класу `StudentInfoPrinter` і використайте його для виведення інформації про студента.
Ці обєкти і всю роботу, виконайте в якомусь тестовому класі, до прикладу, StudentTest з методом main (він вже створений в репозиторії)

В цьому ж методі, за допомогою рефлексії, викличіть приватний метод examScore(), який встановить студенту найвищу оцінку
Виведіть в консоль його нову оцінку

Завдання №2
Створіть клас Person з наступними полями:

private String name (ім'я особи)
private int age (вік особи)
private String address (адреса особи)
Створіть клас PersonFactory, який має наступні методи:

public Person createPerson(String name, int age, String address) - створює об'єкт типу Person із заданими параметрами та повертає його.
public void printFields(Object obj) - використовуючи рефлексію, виводить на консоль всі поля та їх значення для об'єкта, який передається методу. Для визначення типу полів використовуйте метод getClass() або літерал класу MyClass.class.
Створіть об'єкт класу PersonFactory і використайте його для створення об'єкту Person і виведення інформації про його поля.
(створювати обєкти необхідно за допомогою рефлексії -- https://jenkov.com/tutorials/java-reflection/constructors.html)
*у слайдах присутні приклади
*/

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        Student student = new Student("Mykola", "Raskolnikov", 23, 100);
        StudentInfoPrinter studentInfoPrinter = new StudentInfoPrinter();
        String result = studentInfoPrinter.printStudentInfo(student);
        System.out.println(result);

        Class<? extends Student> studentClass = student.getClass();
        Field examScore = studentClass.getDeclaredField("examScore");
        examScore.setAccessible(true);
        int firstExamScore = examScore.getInt(student);
        System.out.println("First student's examScore is " + firstExamScore);
        examScore.set(student, 200);
        System.out.println("Second student's examScore is " + student.getExamScore());

        System.out.println("---");

        PersonFactory person = new PersonFactory();
        person.printFields(person);
    }
}