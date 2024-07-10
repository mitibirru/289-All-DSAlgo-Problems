package graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstras {
    private int v;
    private List<List<Pair>> adj;

    Dijkstras(int v) {
        this.v = v;

        adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
    }
    
    public int[] shortestPath(int src) {
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(v, (a, b) -> a.dist - b.dist); //minheap
        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()) {
            int currNode = pq.poll().node;

            for (Pair p : adj.get(currNode)) {
                if (dist[p.node] > dist[currNode] + p.dist) {
                    dist[p.node] = dist[currNode] + p.dist;
                    pq.add(new Pair(p.node, dist[currNode] + p.dist));
                }
            }
        }
        return dist;
    }
}

class Pair {
    int dist;
    int node;

    Pair(int node, int dist) {
        this.dist = dist;
        this.node = node;
    }
}