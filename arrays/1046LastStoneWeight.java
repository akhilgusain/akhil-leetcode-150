package arrays;

import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        // make a max heap 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b)->b-a);
        //add all stones to heap
        for(int stone : stones){
            maxHeap.add(stone);
        }
        while(maxHeap.size() > 1){
            int x = maxHeap.poll(); // poll the heaviest stone
            int y = maxHeap.poll(); // poll the second heaviest stone

            if(x!=y){
                maxHeap.add(x-y); // add the remaining stones to heap
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}