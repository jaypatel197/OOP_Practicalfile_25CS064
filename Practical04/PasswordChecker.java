public class PasswordChecker {
    public static String strength(String pw) {
        int count = 0;
        if (pw.length() >= 8) count++;
        if (pw.matches(".*[A-Z].*")) count++;
        if (pw.matches(".*[0-9].*")) count++;
        if (pw.matches(".*[!@#$%^&*].*")) count++;

        if (count <= 1) return "Weak";
        else if (count <= 3) return "Medium";
        else return "Strong";
    }

    public static void main(String[] args) {
        String p1 = "abc";
        String p2 = "Abcd1234!";

        System.out.println(p1 + " -> " + strength(p1));
        System.out.println(p2 + " -> " + strength(p2));
    }
}