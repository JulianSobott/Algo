package travelling_salesman.greedy;

import travelling_salesman.DistancesParser;

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
            idxCurrent = findShortestDistance(route, distances[idxCurrent]);
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



    private static int findShortestDistance(int[] route, int[] row){
        double current_minimum = Double.POSITIVE_INFINITY;
        int currentIdx = 0;
        int idxCity = -1;

        for(int distance : row){
            if(distance != 0 && !contains(route, currentIdx)){
                if(distance < current_minimum){
                    current_minimum = distance;
                    idxCity = currentIdx;
                }
            }
            currentIdx++;
        }
        return idxCity;
    }

    static boolean contains(int route[], int idx){
        for(int v : route){
            if(v == idx){
                return true;
            }
        }
        return false;
    }
}
