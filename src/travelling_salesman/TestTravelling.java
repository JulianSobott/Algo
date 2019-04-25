package travelling_salesman;

import travelling_salesman.complete_enumeration.CompleteEnumeration;
import travelling_salesman.greedy.GreedyAlgorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestTravelling {

    @org.junit.jupiter.api.Test
    void test_greedy(){
        String filePath = "Resources/distances.txt";
        int[] route = GreedyAlgorithm.solve(filePath, 0, 4);
        int[] expected = {0, 2, 1, 3, 0};
        assertArrayEquals(route, expected);
    }

    @org.junit.jupiter.api.Test
    void test_greedy_all(){
        String filePath = "Resources/distances.txt";
        int[] route = GreedyAlgorithm.solve(filePath, 0, -1);
        System.out.println(Arrays.toString(route));
    }

    @org.junit.jupiter.api.Test
    void test_completeEnumeration(){
        String filePath = "Resources/distances.txt";
        int[] route = CompleteEnumeration.solve(filePath, 0, 14);
        System.out.println(Arrays.toString(route));
    }
}
