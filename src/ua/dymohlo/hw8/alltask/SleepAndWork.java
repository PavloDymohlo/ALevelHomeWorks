package ua.dymohlo.hw8.alltask;
/*Task1:
- Створити класс з двома private змінними;
- Змінні ініціалізувати через конструктор;
- Створити два public метода для відображення значення змінних.
*/

public class SleepAndWork {
    private int workHours;
    private int sleep;

    public SleepAndWork(int hours, int sleep) {
        this.workHours = hours;
        this.sleep = sleep;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        if (workHours < 8) {
            System.out.println("You worked very little time!");
        } else {
            System.out.println("You worked " + (this.workHours = workHours) + " hours! Now you can rest.");
        }
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        if (sleep > 8) {
            System.out.println("You cannot sleep so much! ");
        } else {
            System.out.println("You slept " + (this.sleep = sleep) + " hours.");
        }
    }
}
