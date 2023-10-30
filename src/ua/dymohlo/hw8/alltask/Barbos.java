package ua.dymohlo.hw8.alltask;
public class Barbos extends Dog {

    public Barbos(String name, String kindOFood, int hoursOfSleeping) {

        super(name, kindOFood, hoursOfSleeping);
    }

    @Override
    public void setKindOFood() {
        System.out.println("i like fish");
    }
}
