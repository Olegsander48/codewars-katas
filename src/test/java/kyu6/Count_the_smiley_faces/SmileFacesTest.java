package kyu6.Count_the_smiley_faces;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.Random;
import java.util.*;

class SmileFacesTest {
    Random rand = new Random();
    StringBuilder sb;
    List<String> a;
    String[] REFERENCE_ARR = new String[] {":::;;;op8'(54", "---~~~~xdpo28", "DDDD))))xXdpP"};

    private int countExpectedSmileys(List<String> arr) {
        return arr.stream().mapToInt(w -> w.matches("^[:;][-~]?[)D]$") ? 1 : 0 ).sum();
    }

    @Test
    public void test1() {
        List<String> a = new ArrayList<>();
        a.add(":)"); a.add(":D"); a.add(":-}"); a.add(":-()");
        assertThat(SmileFaces.countSmileys(a)).isEqualTo(2);
    }

    @Test
    public void test2() {
        List<String> a = new ArrayList<>();
        a.add(":)"); a.add("XD"); a.add(":0}"); a.add("x:-"); a.add("):-"); a.add("D:");
        assertThat(SmileFaces.countSmileys(a)).isEqualTo(1);
    }

    @Test
    public void test4() {
        List<String> a = new ArrayList<>();
        a.add(":)"); a.add(":D"); a.add("X-}"); a.add("xo)"); a.add(":X"); a.add(":-3"); a.add(":3");
        assertThat(SmileFaces.countSmileys(a)).isEqualTo(2);
    }

    @Test
    public void test5() {
        List<String> a = new ArrayList<>();
        a.add(":)"); a.add(":)"); a.add("x-]"); a.add(":ox"); a.add(";-("); a.add(";-)"); a.add(";~("); a.add(":~D");
        assertThat(SmileFaces.countSmileys(a)).isEqualTo(4);
    }

    @Test
    public void initiateRandTests() {
        for (int i=0; i<100; i++) {

            a = new ArrayList<>();

            int m = rand.nextInt(20) + 20;
            for (int h=0; h<=m; h++) {
                sb = new StringBuilder();

                int j = 0;
                if (rand.nextInt(15) < 1)
                    sb.append( REFERENCE_ARR[1].charAt(rand.nextInt(REFERENCE_ARR[1].length())) );       // surnumeraire (in french)

                sb.append( REFERENCE_ARR[j].charAt(rand.nextInt(REFERENCE_ARR[j++].length())) );         // eyes
                if (rand.nextInt(2) < 1) {
                    sb.append( REFERENCE_ARR[j].charAt(rand.nextInt(REFERENCE_ARR[j++].length())) );     // nose
                    if (rand.nextInt(15) < 1)
                        sb.append( REFERENCE_ARR[1].charAt(rand.nextInt(REFERENCE_ARR[1].length())) );   // nose surnumeraire (in french)
                }
                sb.append( REFERENCE_ARR[2].charAt(rand.nextInt(REFERENCE_ARR[2].length())) );           // mouth

                if (rand.nextInt(15) < 1)
                    sb.append( REFERENCE_ARR[2].charAt(rand.nextInt(REFERENCE_ARR[2].length())) );       // surnumeraire (in french)

                a.add(sb.toString());
            }
            assertThat(SmileFaces.countSmileys(a)).isEqualTo(countExpectedSmileys(a));
        }
    }

}