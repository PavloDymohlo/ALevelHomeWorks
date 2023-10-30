package ua.dymohlo.hw8.alltask;

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

    public  void setKindOFood() {
        System.out.println(kindOFood);
    }

    public final void getHoursOfSleeping() {
        System.out.println("all dogs sleep "+hoursOfSleeping+" on day.");
    }
}
