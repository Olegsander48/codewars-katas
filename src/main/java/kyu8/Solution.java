package kyu8;

import java.util.stream.Collectors;

public class Solution {
    public static String doubleChar(String s){
        return s.chars()
                .mapToObj(s1 -> (char) s1 + "" + (char) s1)
                .collect(Collectors.joining());
    }
}
