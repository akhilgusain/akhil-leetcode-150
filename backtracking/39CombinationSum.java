package backtracking;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> combinations = new ArrayList<>();
        backTrack(target, res, combinations, candidates, 0);
        return res;
    }

    public void backTrack(int target, List<List<Integer>> result, List<Integer> combinations,
            int[] candidates, int start) {
        if (target == 0) { // that means combination is valid hence return value
            result.add(new ArrayList<Integer>(combinations));
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            combinations.add(candidates[i]);
            backTrack(target - candidates[i], result, combinations, candidates, i);
            combinations.remove(combinations.size() - 1); // since last element we will correct
        }
    }
}
