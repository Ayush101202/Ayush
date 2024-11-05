import java.util.Scanner;

class Time {

    int hour = 0;
    int minute = 0;
    int second = 0;

    void setTime() {
        Scanner sc = new Scanner(System.in);
        int h, m, s;

        System.out.println("------------------");

        System.out.print("\nEnter hour: ");
        h = sc.nextInt();
        System.out.print("\nEnter minute: ");
        m = sc.nextInt();
        System.out.print("\nEnter second: ");
        s = sc.nextInt();

        hour = h;
        minute = m;
        second = s;
    }

    int[] adjust(int a, int b) {
        if (a >= 60) {
            b += 1;
            a -= 60;
        }
        return new int[] { a, b };
    }

    void sum(Time t1, Time t2) {
        int[] values;
        second = t1.second + t2.second;
        values = adjust(second, minute);
        second = values[0];
        minute = values[1];

        minute = t1.minute + t2.minute;
        values = adjust(minute, hour);
        minute = values[0];
        hour = values[1];

        hour = t1.hour + t2.hour;
    }

    void dif(Time t1, Time t2) {
        // converting into seconds before calculating the difference
        int secT1 = 0, secT2 = 0, diff;

        secT1 += t1.hour * 3600;
        secT1 += t1.minute * 60;
        secT1 += t1.second;

        secT2 += t2.hour * 3600;
        secT2 += t2.minute * 60;
        secT2 += t2.second;

        // calculating the difference
        if (secT1 > secT2) {
            diff = secT1 - secT2;
        } else {
            diff = secT2 - secT1;
        }

        hour = diff / 3600;
        diff -= hour * 3600;
        minute = diff / 60;
        diff -= minute / 60;
        second = diff;
    }

    void display() {
        System.err.println(hour + ":" + minute + ":" + second);
    }
}

public class Assignment2 {

    public static void main(String[] args) {

        Time t1 = new Time(), t2 = new Time(), t3 = new Time(), t4 = new Time();

        System.err.println("Enter Time Frame 1");
        t1.setTime();
        System.err.println("\nEnter Time Frame 2");
        t2.setTime();

        t3.sum(t1, t2); // Sum of two time frames stored in t3 object
        t4.dif(t1, t2); // Difference of two time frames stored in t4 object

        System.out.print("\nFirst time frame: ");
        t1.display();

        System.out.print("\nSecond time frame: ");
        t2.display();

        System.out.print("\nSum: ");
        t3.display();

        System.out.print("\nDifference: ");
        t4.display();

    }
}
