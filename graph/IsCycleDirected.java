package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class IsCycleDirected {
    public static void main(String[] args) {
        IsCycleDirected solution = new IsCycleDirected();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Example graph with 4 vertices
        int V = 4;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the graph
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); // This creates a cycle

        boolean hasCycle = solution.isCyclic(V, adj);
        System.out.println("Graph has cycle: " + hasCycle);
    }

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // Step 1: Calculate in-degree of each vertex
        int[] indegree = new int[V];
        for (ArrayList<Integer> list : adj) {
            for (int nei : list) {
                indegree[nei]++;
            }
        }

        // Step 2: Initialize a queue and enqueue all vertices with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 3: Initialize count of visited vertices
        int count = 0;

        // Step 4: Process vertices in queue
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            // Decrease in-degree for all adjacent vertices
            for (int nei : adj.get(node)) {
                indegree[nei]--;
                // If in-degree becomes zero, add it to the queue
                if (indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }

        // Step 5: Check if topological sort included all vertices
        return count != V;
    }
}
