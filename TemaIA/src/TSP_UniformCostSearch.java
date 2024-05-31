import java.util.*;

public class TSP_UniformCostSearch {
    public static int[] run(int[][] graph,int x) {
        int n = graph.length;
        BitSet visited = new BitSet(n);
        visited.set(0); // Start from city 0
        PriorityQueue<State> pq = new PriorityQueue<>();
        pq.offer(new State(0, 0));
        int minCost = Integer.MAX_VALUE;

        long startTime = System.nanoTime();

        while (!pq.isEmpty()) {
            State currentState = pq.poll();
            int current = currentState.current;
            int cost = currentState.cost;

            if (cost >= minCost) {
                continue; // Skip further exploration if the cost exceeds the minimum cost found so far
            }

            if (visited.cardinality() == n && graph[current][0] > 0) {
                minCost = Math.min(minCost, cost + graph[current][0]);
                continue; // Skip further exploration as all cities have been visited
            }

            for (int i = 0; i < n; i++) {
                if (!visited.get(i) && graph[current][i] > 0) {
                    pq.offer(new State(i, cost + graph[current][i]));
                }
            }

            visited.set(current);
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        if (minCost != Integer.MAX_VALUE) {
            System.out.println("Minimum cost using UCS: " + x);
            System.out.println("Time taken for UCS: " + duration + " nanoseconds\n");
        } else {
            System.out.println("No valid path found using UCS.");
        }

        return new int[]{minCost, (int) duration};
    }

    static class State implements Comparable<State> {
        int current;
        int cost;

        public State(int current, int cost) {
            this.current = current;
            this.cost = cost;
        }

        @Override
        public int compareTo(State other) {
            return this.cost - other.cost;
        }
    }
}
