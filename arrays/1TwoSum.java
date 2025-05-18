package arrays;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
    // we will maintain a hashmap which will be formed by iterating the array
    // lets take array's 1st element = value check if its (target - value) is there in hashmap, if not add value to hashmap with its index
    // repeat till we find (target - value) in hashmap and then return the index of element and hashmap value
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                if(map.containsKey(target - nums[i])){
                    return new int[]{i, map.get(target - nums[i])};
                }
                map.put(nums[i], i);
            }
        return new int[]{}; // return an empty array although this case wont occur according to problem
    }
}
