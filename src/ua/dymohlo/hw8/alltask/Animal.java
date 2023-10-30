package ua.dymohlo.hw8.alltask;
public class Animal {
    private String kindOFood;
    private int hoursOfSleeping;

    public Animal(String kindOFood, int hoursOfSleeping) {
        this.kindOFood = kindOFood;
        this.hoursOfSleeping = hoursOfSleeping;
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
