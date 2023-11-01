package ua.dymohlo.hw8.alltask;
/*
Task3:
- Створити спадкоємця з 3 методами;
- Один з методів зробити final;
- Один з методів перевизначити;
- Ініціалізувати змінні через конструктор.
*/

public class Dog {
    private String name;
    private String kindOFood;
    private int hoursOfSleeping;

    public Dog(String name, String kindOFood, int hoursOfSleeping) {
        this.name = name;
        this.kindOFood = "Meat";
        this.hoursOfSleeping = 8;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKindOFood() {
        return kindOFood;
    }

    public void setKindOFood(String kindOFood) {
        this.kindOFood = kindOFood;
    }

    public int getHoursOfSleeping() {
        return hoursOfSleeping;
    }

    public final void setHoursOfSleeping() {
        System.out.println(8);
    }
}
