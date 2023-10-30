package ua.dymohlo.hw8.alltask;
/*
- Створити 3 об'єкти Animal, знайти того , у кого найбільший hoursOfSleeping і вивести те, що він їсть.
*/
public class Main {
    public static void main(String[] args) {
        //task1
        Sleep people = new Sleep(5, 9);
        people.hours();
        people.sleep();

        System.out.println();
        //task3
        Barbos barbos = new Barbos("Barbos", " big fish", 10);
        System.out.println(barbos.getName());
        barbos.setKindOFood();
        barbos.getHoursOfSleeping();

        System.out.println();

        //task2
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
    public static Animal whoSleepsMore(Animal dog, Animal cat, Animal mouse) {
        Animal whoSleeping = dog.getHoursOfSleeping() > cat.getHoursOfSleeping() ? dog.getHoursOfSleeping() >
                mouse.getHoursOfSleeping() ? dog :
                mouse : cat.getHoursOfSleeping() > mouse.getHoursOfSleeping() ? cat : mouse;
        return whoSleeping;
    }
}
