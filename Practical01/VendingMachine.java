import java.util.Scanner;

enum Coin {
    ONE, TWO, FIVE, TEN
}

public class VendingMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = 15;
        int total = 0;

        System.out.println("Snack price: " + price);
        while (total < price) {
            System.out.print("Enter coin (ONE, TWO, FIVE, TEN): ");
            String input = sc.next().toUpperCase();
            Coin coin = Coin.valueOf(input);

            // Switch expression to get coin value
            int value = switch (coin) {
                case ONE -> 1;
                case TWO -> 2;
                case FIVE -> 5;
                case TEN -> 10;
            };

            total += value;
            System.out.println("Total so far: " + total);
        }

        int change = total - price;
        System.out.println("Paid. Change: " + change);
    }
}