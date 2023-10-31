package ua.dymohlo.hw8.alltask;

public class Barbos extends Dog {

    public Barbos(String name, String kindOFood, int hoursOfSleeping) {

        super(name, kindOFood, hoursOfSleeping);
    }

    @Override
    public String getKindOFood() {
        return "Barbos likes fish.";
    }

    @Override
    public final void setHoursOfSleeping(int hoursOfSleeping) {
        System.out.println("Barbos sleeps 10 hours.");
    }
}
