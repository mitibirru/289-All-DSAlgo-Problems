package graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
    public List<Integer> topoSort(List<List<Integer>> adj, int v) {
        int[] indegree = new int[v];
        for (List<Integer> list : adj) {
            for (int nei : list) {
                indegree[nei]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        List<Integer> result = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            for (int nei : adj.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        if (result.size() != v) {
            result.clear();
            return result;
        }

        return result;
    }
}
