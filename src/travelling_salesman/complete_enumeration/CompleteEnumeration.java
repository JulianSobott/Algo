package travelling_salesman.complete_enumeration;

import travelling_salesman.DistancesParser;
import travelling_salesman.greedy.GreedyAlgorithm;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CompleteEnumeration {

    static int[][] distances;
    static int idxStart;
    static int numCities;
    static int shortestDistance = Integer.MAX_VALUE;
    static int[] shortestRoute;

    public static int[] solve(String file_path, int idxStart, Integer numCities) {
        int[] dNumCities = new int[]{numCities};
        int[][] distances = DistancesParser.parseDistances(file_path, dNumCities);
        return CompleteEnumeration.solve(distances, idxStart, dNumCities[0]);
    }

    public static int[] solve(int[][] distances, int idxStart, int numCities) {
        CompleteEnumeration.distances = distances;
        CompleteEnumeration.idxStart = idxStart;
        CompleteEnumeration.numCities = numCities;
        int[] indices = new int[numCities];
        indices[0] = idxStart;
        for(int i = 1; i < numCities; i++){
            if(i != idxStart)
                indices[i] = i;
        }
        CompleteEnumeration.shortestRoute = new int[numCities];
        permute(1, indices);
        System.out.println();
        System.out.println(CompleteEnumeration.shortestDistance);
        System.out.println(Arrays.toString(CompleteEnumeration.shortestRoute));
        return CompleteEnumeration.shortestRoute;
    }

    public  static void permute(int start, int[] input)
    {
        if (start == input.length)
        {
            int distance = 0;
            int prevCity = -1;
            //System.out.println(Arrays.toString(input));
            for (int x: input)
            {
                if(prevCity != -1){
                    distance += CompleteEnumeration.distances[prevCity][x];
                }
                prevCity = x;
            }
            distance += CompleteEnumeration.distances[prevCity][CompleteEnumeration.idxStart];
            if(distance < CompleteEnumeration.shortestDistance){
                System.arraycopy(input, 0, CompleteEnumeration.shortestRoute, 0, input.length);
                CompleteEnumeration.shortestDistance = distance;
            }
            //System.out.println(distance);
            return;
        }

        for (int i = start; i < input.length; i++)
        {
            // swapping
            int temp = input[i];
            input[i] = input[start];
            input[start] = temp;
            // swap(input[i], input[start]);

            permute(start + 1, input);
            // swap(input[i],input[start]);

            int temp2 = input[i];
            input[i] = input[start];
            input[start] = temp2;
        }
    }
}
