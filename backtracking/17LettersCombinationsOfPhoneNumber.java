package backtracking;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // mapping of digits to letters
    private String[] digitToLetters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        backTrack(combinations, digits, "", 0);
        return combinations;
    }

    private void backTrack(List<String> combinations, String digits, String currentCombination, int index) {
        if (index == digits.length()) {
            // since if digits is 23 we check if we got 2 as output then add
            combinations.add(currentCombination);
            return;
        }

        String letters = digitToLetters[digits.charAt(index) - '0'];

        for (char letter : letters.toCharArray()) {
            backTrack(combinations, digits, currentCombination + letter, index + 1);
        }
    }
}
