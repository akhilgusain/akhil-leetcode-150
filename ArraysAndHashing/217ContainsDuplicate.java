package arraysandhashing;
import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Create a HashSet to store elements from the array
        HashSet<Integer> seenNumbers = new HashSet<>();
        // Iterate through each element in the array
        for(int num : nums){
            // Check if the element in the array 
            if(seenNumbers.contains(num)){
                return true; // Duplicate found
            }
            // ADd the element to the HashSet
            seenNumbers.add(num);
        }
        return false; // No duplicates found
    }
}