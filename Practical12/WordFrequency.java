import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "java is fun and java is powerful and java is cool";
        String[] words = text.split(" ");

        HashMap<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> e : list) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }
}