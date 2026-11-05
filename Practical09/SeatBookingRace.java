class Booking {
    int seats = 5;

    synchronized void book(String name) {
        if (seats > 0) {
            System.out.println(name + " booked seat. Remaining: " + (--seats));
        } else {
            System.out.println(name + " failed to book (Full)");
        }
    }
}

public class SeatBookingRace {
    public static void main(String[] args) throws Exception {
        Booking b = new Booking();
        Thread[] t = new Thread[10];

        for (int i = 0; i < 10; i++) {
            String name = "User-" + (i + 1);
            t[i] = new Thread(() -> b.book(name));
            t[i].start();
        }

        for (Thread th : t) th.join();
    }
}