package slidingwindow;

import java.util.HashMap;
import java.util.Map;

//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"

class Solution {
    public static String minWindow(String s, String t) {
        if (t.length() == 0) return "";

        // Frequency map for `t`
        Map<Character, Integer> mpt = new HashMap<>();
        Map<Character, Integer> mps = new HashMap<>(); // this is the frequency map which we will add or remove counts

        // Populate the frequency map for `t`
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            mpt.put(c, mpt.getOrDefault(c, 0) + 1);
        }

        int matchedCount = 0, total = mpt.size(); // matchedCount means total number of characters matched
        int i = 0, j = 0;
        int res = Integer.MAX_VALUE;
        int start = 0, end = 0; // start is start index and end is end index

        while (j < s.length()) {
            char endChar = s.charAt(j);

            // Expand the window
            if (mpt.containsKey(endChar)) {
                mps.put(endChar, mps.getOrDefault(endChar, 0) + 1); // otherwise just keep entering in s hashmap
                if (mps.get(endChar).intValue() == mpt.get(endChar).intValue()) { // if frequency matches increment count
                    matchedCount++;
                }
            }

            // Shrink the window
            while (matchedCount == total) {
                // Update the result
                if (j - i + 1 < res) {
                    res = j - i + 1;
                    start = i;
                    end = j;
                }

                // shrink by incrementing i pointer and also decreasing frequency in mps 
                // if it is there in mpt then decrement the count

                char startChar = s.charAt(i);

                if (mps.containsKey(startChar)) {
                    mps.put(startChar, mps.get(startChar) - 1); // {A : 0 ...}
                    if (mpt.containsKey(startChar) && mps.get(startChar) < mpt.get(startChar)) {
                        matchedCount--;
                    }
                }
                i++;
            }
            j++;
        }

        if (res == Integer.MAX_VALUE) return "";

        // Return the result substring
        return s.substring(start, end + 1);
}
}
