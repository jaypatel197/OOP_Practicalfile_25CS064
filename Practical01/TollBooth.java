import java.util.Scanner;

record Vehicle(String number, String type) {}

public class TollBooth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalToll = 0;
        int bike = 0, car = 0, truck = 0;

        while (true) {
            System.out.print("Enter vehicle number: ");
            String num = sc.next();
            if (num.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter vehicle type (bike/car/truck): ");
            String type = sc.next().toLowerCase();

            Vehicle v = new Vehicle(num, type);

            int toll = switch (v.type()) {
                case "bike" -> {
                    bike++;
                    yield 20;
                }
                case "car" -> {
                    car++;
                    yield 50;
                }
                case "truck" -> {
                    truck++;
                    yield 150;
                }
                default -> 0;
            };

            totalToll += toll;
        }

        System.out.println("Total toll: " + totalToll);

        String most = "car";
        if (bike > car && bike > truck) most = "bike";
        else if (truck > car && truck > bike) most = "truck";

        System.out.println("Most frequent: " + most);
    }
}