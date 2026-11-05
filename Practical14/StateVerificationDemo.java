import java.util.ArrayList;

public class StateVerificationDemo {
    public static void main(String[] args) {
        ArrayList<String> data = new ArrayList<>();
        data.add("A101: 5000");
        data.add("A102: 7000");

        System.out.println("Saved State: " + data);

        ArrayList<String> reloaded = new ArrayList<>(data);
        System.out.println("Reloaded State: " + reloaded);

        if (data.equals(reloaded)) {
            System.out.println("Verification PASS: Data matches perfectly");
        } else {
            System.out.println("Verification FAIL");
        }
    }
}