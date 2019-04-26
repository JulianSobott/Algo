package travelling_salesman;

public class Utils {

    public static int findShortestDistance(int[] route, int[] row){
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
