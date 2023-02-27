package kyu6.Count_the_smiley_faces;

import java.util.List;
import java.util.regex.Pattern;

public class SmileFaces {
    public static int countSmileys(List<String> arr) {
        Pattern pattern = Pattern.compile("^[:;][-~]?[)D]$");
        return (int) arr.stream()
                .filter(s -> pattern.matcher(s).find())
                .count();
    }
}
