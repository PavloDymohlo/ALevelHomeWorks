package ua.dymohlo.hw8.alltask;

/*
Task1:
- Створити класс з двома private змінними;
- Змінні ініціалізувати через конструктор;
- Створити два public метода для відображення значення змінних.

Task2:
- Створити 3 об'єкти Animal, знайти того , у кого найбільший hoursOfSleeping і вивести те, що він їсть.

Task3:
- Створити спадкоємця з 3 методами;
- Один з методів зробити final;
- Один з методів перевизначити;
- Ініціалізувати змінні через конструктор.
*/
public class Main {
    public static void main(String[] args) {
        sleepAndWork();
        System.out.println();
        sleepAndEat();
        System.out.println();
        dogHeir();
    }

    private static void sleepAndWork() {
        SleepAndWork people = new SleepAndWork(5, 12);
        people.setSleep(7);
        people.setWorkHours(10);
    }

    private static void sleepAndEat() {
        Animal dog = new Animal("bone", 5);
        Animal cat = new Animal("fish", 8);
        Animal mouse = new Animal("cheese", 9);
        if (whoSleepsMore(dog, cat, mouse) == dog) {
            System.out.println("The animal that sleeps the longest is dog and its favorite food is " + dog.getKindOFood());
        }
        if (whoSleepsMore(dog, cat, mouse) == cat) {
            System.out.println("The animal that sleeps the longest is cat and its favorite food is " + cat.getKindOFood());
        }
        if (whoSleepsMore(dog, cat, mouse) == mouse) {
            System.out.println("The animal that sleeps the longest is mouse and its favorite food is " + mouse.getKindOFood());
        }
    }

    private static Animal whoSleepsMore(Animal dog, Animal cat, Animal mouse) {
        Animal whoSleeping = dog.getHoursOfSleeping() > cat.getHoursOfSleeping() ? dog.getHoursOfSleeping() >
                mouse.getHoursOfSleeping() ? dog :
                mouse : cat.getHoursOfSleeping() > mouse.getHoursOfSleeping() ? cat : mouse;
        return whoSleeping;
    }

    private static void dogHeir() {
        Barbos barbos = new Barbos("Barbos", " big fish", 10);
        System.out.println(barbos.getName());
        barbos.setHoursOfSleeping();
        System.out.println(barbos.getKindOFood());
    }
}
