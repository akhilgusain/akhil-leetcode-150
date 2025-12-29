package HeapOrPriorityQueues;
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Input: nums = [3,2,1,5,6,4], k = 2
        // for smallest kth
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // here we added k elements from start
        // then we iterate remaining and remove top value from heap and add them if they are larger than heap top value
        // dry run
        // [3,2] for 1 no change
        // for 5 the heap is [3,5]
        // for 6 the heap is [5,6]
        // for 4 no change hence we return top element i.e 5

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < k; i++){
            minHeap.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++){
            if(nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
