package BackTracking;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubset(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void generateSubset(int index, int[] nums, List<Integer> tempList, List<List<Integer>> result) {
        result.add(new ArrayList<>(tempList));
        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            generateSubset(i + 1, nums, tempList, result);
            tempList.remove(tempList.size() - 1);
        }
    }

}
