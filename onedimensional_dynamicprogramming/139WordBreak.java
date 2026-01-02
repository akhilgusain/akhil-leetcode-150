package onedimensional_dynamicprogramming;

import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1]; // dp[i] means s[i:end] can be segmented
        dp[s.length()] = true; // base case

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w : wordDict) { // iterate through each word in the dictionary
                if ((i + w.length()) <= s.length() &&
                        s.substring(i, i + w.length()).equals(w)) { // check if the word matches
                    dp[i] = dp[i + w.length()]; // update dp[i] based on the matched word
                }
                if (dp[i]) { // early stopping if we found a valid segmentation
                    break;
                }
            }
        }

        return dp[0]; // return whether the whole string can be segmented
    }
}
