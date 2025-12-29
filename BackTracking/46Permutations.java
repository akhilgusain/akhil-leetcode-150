package BackTracking;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> current,
            int[] nums, boolean[] used) {
        if (current.size() == nums.length) { // that means result has been achieved
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) { // if the element has not been used
                current.add(nums[i]); // add it to current consideration
                used[i] = true; // set it to used
                backTrack(result, current, nums, used);
                used[i] = false;
                current.remove(current.size() - 1); // remove last consideration and continue...
            }
        }
    }
}
