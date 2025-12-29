package heap;

import java.util.PriorityQueue;


class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Max heap sorted by farthest distance
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1], a[0] * a[0] + a[1] * a[1]) // largest first
        );
        
        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove farthest i.e biggest
            }
        }
        
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
    
}

