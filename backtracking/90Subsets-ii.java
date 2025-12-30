package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // we will sort the array since we need to handle duplicates
        backTrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void backTrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
                // for next duplicate element we will not consider it in result
            }
            current.add(nums[i]);
            backTrack(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }
}