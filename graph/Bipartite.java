package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    /**
     * Function to check if graph is bipartite.
     * 
     * @param v   the number of vertices in the graph
     * @param adj the adjacency list representing the graph
     * @return true if the graph is bipartite, false otherwise
     */

    /**
     * Helper function to perform BFS and check for bipartiteness.
     *
     * @param start the source vertex to start BFS
     * @param color the array to store colors of vertices
     * @param adj   the adjacency list representing the graph
     * @param n     the number of vertices in the graph
     * @return true if the component is bipartite, false otherwise
     */
    private boolean check(int start, ArrayList<ArrayList<Integer>> adj, int[] color, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int nei : adj.get(curr)) {
                // If the neighbor is not colored, color it with the opposite color
                if (color[nei] == -1) {
                    color[nei] = 1 - color[curr];
                    q.add(nei);
                }
                // If the neighbor has the same color as the current node, it's not bipartite
                else if (color[nei] == color[curr])
                    return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>> adj) {
        int color[] = new int[v];

        Arrays.fill(color, -1); // Initialize all vertices as uncolored

        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                // If the vertex is not colored, perform BFS
                if (!check(i, adj, color, v))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] input = br.readLine().trim().split(" ");
            int V = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                String[] edge = br.readLine().trim().split(" ");
                int u = Integer.parseInt(edge[0]);
                int v = Integer.parseInt(edge[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Bipartite obj = new Bipartite();
            boolean ans = obj.isBipartite(V, adj);
            System.out.println(ans ? "1" : "0");
        }
    }
}