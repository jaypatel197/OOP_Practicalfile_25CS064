interface Switchable {
    void on();
    void off();
    default void toggle() {
        System.out.println("Toggling device state");
        on();
    }
}

class Fan implements Switchable {
    public void on() { System.out.println("Fan is ON"); }
    public void off() { System.out.println("Fan is OFF"); }
}

class Light implements Switchable {
    public void on() { System.out.println("Light is ON"); }
    public void off() { System.out.println("Light is OFF"); }
}

@FunctionalInterface
interface CheckRule {
    boolean allow(String device, int hour);
}

public class RemoteControlDemo {
    public static void main(String[] args) {
        Switchable[] devices = { new Fan(), new Light() };
        for (Switchable s : devices) {
            s.toggle();
        }

        // Anonymous class
        CheckRule rule1 = new CheckRule() {
            public boolean allow(String device, int hour) {
                return hour >= 6 && hour <= 18;
            }
        };

        // Lambda expression
        CheckRule rule2 = (device, hour) -> hour > 18;

        System.out.println("Rule 1 (Day): " + rule1.allow("Light", 10));
        System.out.println("Rule 2 (Night): " + rule2.allow("Light", 20));
    }
}