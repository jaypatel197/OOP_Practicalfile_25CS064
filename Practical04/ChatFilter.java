import java.util.Scanner;

public class ChatFilter {
    public static void main(String[] args) {
        String[] logs = {
            "10:05 alice Hello there",
            "wrong_format_line",
            "10:08 bob Good morning"
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter keyword: ");
        String keyword = sc.next().toLowerCase();

        int matches = 0;
        StringBuilder sb = new StringBuilder();

        for (String line : logs) {
            String[] parts = line.split(" ", 3);
            if (parts.length < 3) {
                continue;
            }

            String time = parts[0];
            String user = parts[1];
            String msg = parts[2];

            if (msg.toLowerCase().contains(keyword)) {
                matches++;
                sb.append(time).append(" ").append(user).append(": ").append(msg).append("\n");
            }
        }

        System.out.println("Matches: " + matches);
        System.out.print(sb.toString());
    }
}