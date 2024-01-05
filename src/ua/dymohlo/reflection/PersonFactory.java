package ua.dymohlo.reflection;
/*
Створіть клас PersonFactory, який має наступні методи:
public Person createPerson(String name, int age, String address) - створює об'єкт типу Person із заданими параметрами та повертає його.
public void printFields(Object obj) - використовуючи рефлексію, виводить на консоль всі поля та їх значення для об'єкта,
який передається методу. Для визначення типу полів використовуйте метод getClass() або літерал класу MyClass.class.
Створіть об'єкт класу PersonFactory і використайте його для створення об'єкту Person і виведення інформації про його поля.
(створювати обєкти необхідно за допомогою рефлексії -- https://jenkov.com/tutorials/java-reflection/constructors.html)
*у слайдах присутні приклади
*/

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class PersonFactory {

    public Person createPerson() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class newPerson = Class.forName(Person.class.getName());
        Class[] constructorParameter = {String.class, int.class, String.class};
        Person person = (Person) newPerson.getConstructor(constructorParameter).newInstance("Lars Ulrich", 59, "Los Angeles");
        return person;
    }

    public void personPrintFields(Object obj1) throws IllegalAccessException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        Object obj = createPerson();
        Class<Person> aClass = (Class<Person>) obj.getClass();
        for (Field field : aClass.getDeclaredFields()) {
            field.setAccessible(true);
            Object o = field.get(obj);
            System.out.print(o + ", ");
        }
    }
}
