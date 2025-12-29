package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // check edge cases if input is null or k <=0
        if(nums == null || nums.length == 0 || k <= 0){
            return new int[0];
        }

        // approach would be to store index value inside deque
        // we will only store result once we reach k length in iteration

        
        int n = nums.length;
        int[] result = new int[n - k + 1]; //array of window length
        Deque<Integer> deque = new LinkedList<>(); // deque will have index

        for(int i = 0; i < n; i++){
            // Remove indices that are out of the current window
            while(!deque.isEmpty() && deque.peek() < i - k + 1){ // i - k + 1 is the first index of current window
                deque.poll();
            }

            // Remove indices whose corresponding values are less than nums[i]
            // maintain decreasing order
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();    
            }

            // Add the current index to the queue
            deque.offer(i);

            // Add the maximum element of the current window to the result
            if(i >= k - 1){
                result[i - k + 1] = nums[deque.peek()];
            }
        }
        return result;
    }
}
