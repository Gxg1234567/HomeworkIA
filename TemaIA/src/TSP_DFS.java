import java.util.*;

public class TSP_DFS {
    static int minCost = Integer.MAX_VALUE;
    static int[][] graph;
    static int n;

    public static void run(int[][] inputGraph) {
        graph = inputGraph;
        n = graph.length;

        BitSet visited = new BitSet(n);
        visited.set(0); // Start from city 0
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        List<Integer> path = new ArrayList<>();
        path.add(0);

        long startTime = System.nanoTime();

        dfs(stack, visited, path, 0);

        long endTime = System.nanoTime();
        double duration = endTime - startTime;

        if (minCost != Integer.MAX_VALUE) {
            System.out.println("Minimum cost using DFS: " + minCost);
        } else {
            System.out.println("No valid path found using DFS.");
        }
        System.out.println("Time taken for DFS: " + duration + " nanoseconds\n");
    }

    private static void dfs(Stack<Integer> stack, BitSet visited, List<Integer> path, int costSoFar) {
        if (path.size() == n) {
            int lastCity = path.get(path.size() - 1);
            int cost = costSoFar + graph[lastCity][0];
            if (cost < minCost) {
                minCost = cost;
            }
            return;
        }

        int current = stack.peek();

        for (int i = 0; i < n; i++) {
            if (!visited.get(i) && graph[current][i] > 0) {
                if (costSoFar + graph[current][i] < minCost) {
                    stack.push(i);
                    visited.set(i);
                    path.add(i);
                    dfs(stack, visited, path, costSoFar + graph[current][i]);
                    path.remove(path.size() - 1);
                    visited.clear(i);
                    stack.pop();
                }
            }
        }
    }
    public static int costul(){
        return minCost;
    }
}
