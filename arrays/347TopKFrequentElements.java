package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length){
            return nums;
        }
        // maintain a hashmap for counting frequency
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // now we will use priorityQueue which will evict least priority elements if size exceeds 
        Queue<Integer> heap = new PriorityQueue<>(
            (a,b) -> map.get(a) - map.get(b)
        );

        // iterate hashmap and keep on adding to heap until heap size gets more than k
        // if heap size gets more than k then we remove element from heap
        // heap will remove element with least priority i.e least count
        
        for(int n : map.keySet()){
            heap.add(n);
            if(heap.size() > k) heap.poll();
        }
        int ans[] = new int[k];
        for(int i=0; i < k; i++){
            ans[i] = heap.poll();
        }
        return ans;
    }
}
