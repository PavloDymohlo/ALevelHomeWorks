package ua.dymohlo.hw8.alltask;

/*Task2:
- Створити 3 об'єкти Animal, знайти того , у кого найбільший hoursOfSleeping і вивести те, що він їсть.
 */
public class Animal {
    private String kindOFood;
    private int hoursOfSleeping;

    public Animal(String kindOFood, int hoursOfSleeping) {
        this.kindOFood = kindOFood;
        this.hoursOfSleeping = hoursOfSleeping;
    }

    public Animal() {
    }

    public String getKindOFood() {
        return kindOFood;
    }

    public int getHoursOfSleeping() {
        return hoursOfSleeping;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "kindOFood='" + kindOFood + '\'' +
                ", hoursOfSleeping=" + hoursOfSleeping +
                '}';
    }
}
