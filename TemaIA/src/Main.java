import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] graph = GraphGenerator.generateGraph(14);

        System.out.println("Graph generated:");
        printGraph(graph);

        System.out.println("\nRunning TSP algorithms:");
        TSP_DFS.run(graph);
        int x = 0;
        x=TSP_DFS.costul();
        TSP_AStar.run(graph,x);
        TSP_UniformCostSearch.run(graph,x);


    }

    private static void printGraph(int[][] graph) {
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

}
