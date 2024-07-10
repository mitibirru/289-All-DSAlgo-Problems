package graph;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            throw new IllegalArgumentException("Grid cannot be null or empty");
        }

        Queue<Pair> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        int freshOranges = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                    vis[i][j] = true;
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (q.size() == 0)
            return 0;

        int minimumTime = 0;
        int[] directionRow = { -1, 0, 1, 0 };
        int[] directionCol = { 0, 1, 0, -1 };
        int trackFreshOranges = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            minimumTime += 1;

            for (int i = 0; i < size; i++) {
                Pair rottenOrange = q.poll();
                int r = rottenOrange.x;
                int c = rottenOrange.y;

                for (int j = 0; j < 4; j++) {
                    int newRow = r + directionRow[j];
                    int newCol = c + directionCol[j];

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && !vis[newRow][newCol]
                            && grid[newRow][newCol] == 1) {
                        vis[newRow][newCol] = true;
                        trackFreshOranges++;
                        q.offer(new Pair(newRow, newCol));
                    }
                }
            }
        }

        if (trackFreshOranges != freshOranges)
            return -1;

        return minimumTime;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };

        RottenOranges solution = new RottenOranges();
        int minimumTime = solution.orangesRotting(grid);
        System.out.println("Minimum time required to rot all oranges: " + minimumTime);
    }
}
