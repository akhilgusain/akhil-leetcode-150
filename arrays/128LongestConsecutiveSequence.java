package arrays;
import java.util.HashSet;

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