import java.nio.file.*;
import java.util.*;

public class LogAnalyzer {
    public static void main(String[] args) throws Exception {
        Path f1 = Paths.get("log1.txt");
        Path f2 = Paths.get("log2.txt");

        Files.write(f1, Arrays.asList("10:00 INFO start", "10:02 ERROR disk full"));
        Files.write(f2, Arrays.asList("10:05 INFO running", "10:10 ERROR timeout"));

        int total = 0, errors = 0;
        for (Path p : Arrays.asList(f1, f2)) {
            List<String> lines = Files.readAllLines(p);
            total += lines.size();
            for (String l : lines) {
                if (l.contains("ERROR")) errors++;
            }
            System.out.println(p.getFileName() + " size: " + Files.size(p) + " bytes");
        }

        System.out.println("Total lines: " + total);
        System.out.println("Error lines: " + errors);
    }
}