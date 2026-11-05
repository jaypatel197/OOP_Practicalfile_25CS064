import java.util.LinkedList;

class SharedBuffer {
    LinkedList<Integer> list = new LinkedList<>();
    int limit = 1;

    synchronized void produce(int val) throws Exception {
        while (list.size() == limit) wait();
        list.add(val);
        System.out.println("Produced: " + val);
        notify();
    }

    synchronized void consume() throws Exception {
        while (list.isEmpty()) wait();
        int val = list.removeFirst();
        System.out.println("Consumed: " + val);
        notify();
    }
}

public class ProducerConsumer {
    public static void main(String[] args) throws Exception {
        SharedBuffer b = new SharedBuffer();

        Thread p = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    b.produce(i);
                    Thread.sleep(50);
                }
            } catch (Exception e) {}
        });

        Thread c = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    b.consume();
                    Thread.sleep(80);
                }
            } catch (Exception e) {}
        });

        p.start();
        c.start();
        p.join();
        c.join();
    }
}