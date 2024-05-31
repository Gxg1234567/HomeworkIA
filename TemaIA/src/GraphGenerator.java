import java.util.*;

public class GraphGenerator {
    public static int[][] generateGraph(int n) {
        int[][] graph = new int[n][n];
        Random random = new Random();
        for (int i = 0; i < 14; i++) {
            for (int j = i + 1; j < 14; j++) {
                int weight = random.nextInt(50) + 1; // Random distance between 1 and 100
                graph[i][j] = weight;
                graph[j][i] = weight; // Graph is undirected
            }
        }
        return graph;
    }
}
