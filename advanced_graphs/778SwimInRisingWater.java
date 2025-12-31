package advanced_graphs;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int swimInWater(int[][] grid) {
        // we will use min heap for djikstra algorithm for shortest distance
        // instead of weight we will have to add max till now
        int N = grid.length;

        boolean[][] visit = new boolean[N][N];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0]));

        int[][] directions = {
                { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }
        };

        minHeap.offer(new int[] { grid[0][0], 0, 0 });
        visit[0][0] = true;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int t = curr[0], r = curr[1], c = curr[2]; // time, row and column
            if (r == N - 1 && c == N - 1) { // if the destination is reached
                return t;
            }
            for (int[] dir : directions) {
                int neiR = r + dir[0], neiC = c + dir[1]; // neighbor row and column
                if (neiR >= 0 && neiC >= 0 && neiR < N &&
                        neiC < N && !visit[neiR][neiC]) { // need to check if its not out of bound
                        // and not be visited
                    visit[neiR][neiC] = true; // set it as visited
                    minHeap.offer(new int[] {
                            Math.max(t, grid[neiR][neiC]), // since we need max weight till now
                            neiR, neiC
                    });
                }
            }
        }
        return N * N;
    }
}
