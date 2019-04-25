package travelling_salesman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DistancesParser {

    public static int[][] parseDistances(String file_path, int[] numCities) {
        int realNumCities = numCities[0];
        int[][] distances = null;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file_path));
            String line = br.readLine();
            if (realNumCities == -1) {
                realNumCities = line.length() - line.replace(",", "").length() + 1;
                numCities[0] = realNumCities;
            }
            distances = new int[realNumCities][realNumCities];
            int row = 0;
            int col = 0;

            while (line != null && row < realNumCities) {
                for (String element : line.split(",")) {
                    if(col >= realNumCities) break;
                    distances[row][col++] = Integer.parseInt(element);
                }
                col = 0;
                row++;
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return distances;
    }
}
