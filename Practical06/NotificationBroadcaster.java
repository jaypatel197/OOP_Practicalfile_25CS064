interface Notifier {
    void send(String msg);
}

interface Urgent {}

class UrgentSMS implements Notifier, Urgent {
    public void send(String msg) {
        System.out.println("SMS: " + msg);
    }
}

public class NotificationBroadcaster {
    public static void main(String[] args) {
        Notifier email = msg -> System.out.println("Email: " + msg);
        Notifier urgentSms = new UrgentSMS();

        Notifier[] list = { email, urgentSms };
        String message = "Server Alert!";

        for (Notifier n : list) {
            n.send(message);
            if (n instanceof Urgent) {
                n.send(message); // send twice
            }
        }
    }
}