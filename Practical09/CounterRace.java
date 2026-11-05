class Counter {
    int count = 0;
    void add() { count++; }
    synchronized void safeAdd() { count++; }
}

public class CounterRace {
    public static void main(String[] args) throws Exception {
        Counter c = new Counter();
        Thread[] t = new Thread[10];

        // Unsynchronized
        for (int i = 0; i < 10; i++) {
            t[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) c.add();
            });
            t[i].start();
        }
        for (Thread th : t) th.join();
        System.out.println("Unsynchronized total: " + c.count);

        // Synchronized
        Counter c2 = new Counter();
        for (int i = 0; i < 10; i++) {
            t[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) c2.safeAdd();
            });
            t[i].start();
        }
        for (Thread th : t) th.join();
        System.out.println("Synchronized total: " + c2.count);
    }
}