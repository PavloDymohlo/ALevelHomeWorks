package ua.dymohlo.hw6;

import java.util.Arrays;

/*
Класс Phone.
а) Создайте класс Phone, который содержит переменные(поля) number,
model и weight.
б) Добавить конструктор в класс Phone, который принимает на вход
три параметра для инициализации переменных класса - number, model
и weight.
в) Добавить конструктор, который принимает на вход два параметра
для инициализации переменных класса - number, model.
г) Добавить конструктор без параметров.
д) Создайте три экземпляра этого класса.
ж) Присвоить значения полям класса.
з) Выведите на консоль значения их полей.
и) Добавить в класс Phone методы: receiveCall, имеет один параметр
– имя звонящего. Выводит на консоль сообщение “Звонит {name}”.
getNumber – возвращает номер телефона. Вызвать эти методы для
каждого из объектов.
*/
public class Phone {
    int number;
    String model;
    double weight;

    Phone() {
    }

    Phone(int number, String model) {
        this.number = number;
        this.model = model;
    }

    Phone(int number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public static void main(String[] args) {
        Phone firstPhone = new Phone();
        System.out.println(firstPhone);
        firstPhone.receiveCall("Nokia");
        firstPhone.getNumber(101);

        Phone secondPhone = new Phone(102, "Samsung");
        System.out.println(secondPhone);
        secondPhone.receiveCall("Samsung");
        secondPhone.getNumber(102);

        Phone thirdPhone = new Phone(103, "Lenovo", 175.3);
        System.out.println(thirdPhone);
        thirdPhone.receiveCall("Lenovo");
        thirdPhone.getNumber(103);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number=" + number +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void receiveCall(String call) {
        this.model = call;
        System.out.println("Calling " + call);
    }

    public void getNumber(int numberPhone) {
        this.number = numberPhone;
        System.out.println("The number is calling you: " + numberPhone);
    }
}
