package ua.dymohlo.hw8.alltask;

public class Sleep {
    private int workHours;
    private int sleep;

    public Sleep(int hours, int sleep) {
        this.workHours = hours;
        this.sleep = sleep;
    }

    public void hours() {

        System.out.println("Time to work " + workHours + " hours");
    }

    public void sleep() {
        System.out.println("Time to relax " + sleep + " hours");
    }
}

