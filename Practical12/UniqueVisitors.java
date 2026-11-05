import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {
        String[] logins = { "jay", "ansh", "jay", "rahul", "ansh", "meet" };

        HashSet<String> unique = new HashSet<>(Arrays.asList(logins));
        LinkedHashSet<String> ordered = new LinkedHashSet<>(Arrays.asList(logins));

        System.out.println("Unique count: " + unique.size());
        System.out.println("First three distinct:");

        int c = 0;
        for (String s : ordered) {
            System.out.println(s);
            if (++c == 3) break;
        }
    }
}