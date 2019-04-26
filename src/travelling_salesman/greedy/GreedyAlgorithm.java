package travelling_salesman.greedy;

import travelling_salesman.DistancesParser;
import travelling_salesman.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class GreedyAlgorithm {

    public static int[] solve(int[][] distances, int idxStart, int numCities) {
        int[] route = new int[numCities + 1];
        route[0] = idxStart;
        int numVisited = 0;
        int idxCurrent = idxStart;
        while (numVisited + 1 < numCities){
            idxCurrent = Utils.findShortestDistance(route, distances[idxCurrent]);
            if(idxCurrent != -1){
                route[numVisited++ + 1] = idxCurrent;
            }else{
                route[numCities] = idxStart;
            }
        }
        return route;
    }

    public static int[] solve(String file_path, int idxStart, Integer numCities) {
        int[] dNumCities = new int[]{numCities};
        int[][] distances = DistancesParser.parseDistances(file_path, dNumCities);
        return GreedyAlgorithm.solve(distances, idxStart, dNumCities[0]);
    }
}
