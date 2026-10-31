package arraysandhashing;
import java.util.HashSet;

/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * Difficulty: Medium
 *
 * Given an unsorted array of integers nums, return the length of the
 * longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 *   Input:  nums = [100,4,200,1,3,2]
 *   Output: 4
 *   Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 *                Therefore its length is 4.
 *
 * Example 2:
 *   Input:  nums = [0,3,7,2,5,8,4,6,0,1]
 *   Output: 9
 *
 * Example 3:
 *   Input:  nums = [1,0,1,2]
 *   Output: 3
 *
 * Constraints:
 *   - 0 <= nums.length <= 10^5
 *   - -10^9 <= nums[i] <= 10^9
 */

class Solution {
    public int longestConsecutive(int[] nums) {
        // approach would be to add everything to hashset and then iterate it
        // on each element, check if earlier exist if it do then break out of loop
        // if it dont then check if subsequent element exist 
        // return the longest length at the end
        HashSet<Integer> numSet = new HashSet<>();
        int longestSequenceLength = 0;
        int sequenceLength = 0;

        for(int num : nums){
            numSet.add(num);
        }

        for(int num : numSet){
            if(!numSet.contains(num - 1)){ // if it contains num then break out, so thats why we take !contains
                // it means num is first element of sequence
                sequenceLength = 0;
                while(numSet.contains(num)){
                    sequenceLength++; // increase the counter
                    num++;
                }
                longestSequenceLength = Math.max(longestSequenceLength, sequenceLength);
            }
        }
        return longestSequenceLength;
    }
}
