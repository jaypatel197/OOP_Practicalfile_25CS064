import java.util.*;

class DivideByZeroException extends Exception {
    DivideByZeroException(String msg) {
        super(msg);
    }
}

public class GuardedCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean success = false;
        int attempt = 0;

        while (!success) {
            attempt++;
            try {
                double a = Double.parseDouble(sc.next());
                String op = sc.next().trim();
                double b = Double.parseDouble(sc.next());

                if (b == 0 && op.equals("/")) {
                    throw new DivideByZeroException("Dividing by zero");
                }

                double result = 0;
                switch (op) {
                    case "+": result = a + b; break;
                    case "-": result = a - b; break;
                    case "*": result = a * b; break;
                    case "/": result = a / b; break;
                    default:
                        System.out.println("invalid!!");
                        continue;
                }

                success = true;
                System.out.println("result:" + result);
            } catch (NumberFormatException n) {
                System.out.println(n);
            } catch (DivideByZeroException d) {
                System.out.println(d);
            } finally {
                System.out.println("total no. of attemps:" + attempt);
            }
        }
    }
}