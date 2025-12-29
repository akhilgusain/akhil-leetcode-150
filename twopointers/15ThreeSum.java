package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // first of all we would sort the array
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        // here we fix i to zero and put j as 1 and k as last element
        for(int i = 0; i < nums.length; i++){

            int j = i + 1; 
            int k = nums.length - 1;

            // now we need to check for i if its been greater than 0 and duplicate scenario i.e element before it is same
            if(i > 0 && nums[i] == nums[i-1]) continue;

            // here we will do 2sum i.e through j and k we check the sum while keeping i as constant in an iteration
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0) k--;
                else if(sum < 0) j++;
                else{
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    // here the scenario to avoid duplicate in j and k
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
            }
        }
            return result;
    }
}
