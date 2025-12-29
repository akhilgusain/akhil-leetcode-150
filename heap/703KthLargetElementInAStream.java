package heap;

import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer>minHeap;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(k); //min-heap with a capacity of k

        // add initial elements to the heap
        for(int num : nums){
            add(num);
        }
    }
    
    public int add(int val) {
        if(minHeap.size() < k) minHeap.offer(val); // add the value since the size is yet to be filled
        else if(val > minHeap.peek()){
            minHeap.poll(); // remove the smallest element
            minHeap.offer(val); // add the value to the min heap
        }
        
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */