package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> combination, int[] candidates,
            int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) { // thats the benefit of sorting, we know not to continue
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) { // avoid duplicates in same level
                continue;
            }
            combination.add(candidates[i]);
            backTrack(result, combination, candidates, target - candidates[i], i + 1);
            combination.remove(combination.size() - 1); // backtracking essential step
        }

    }
}
