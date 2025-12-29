package SlidingWindow;

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // edge cases : if string is empty or length is 1
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        // left and right pointer will start from 0 and then we increment right and put entries in hashset
        // if any duplicate entry is found then we keep on increasing left till right - left has unique elements
        // ex : pwwkew
        int left = 0;
        int right = 0;
        int ans = 0;
        // hashset to store character and check for duplicates
        HashSet<Character> hashSet = new HashSet<>();

        while(right < s.length()){
            char c = s.charAt(right);
            // right pointer used to iterate and left to remove the duplicates
            // if duplicate is found then use left pointer and delete all occurence
            while(hashSet.contains(c)){
                hashSet.remove(s.charAt(left));
                left++;
            }
            hashSet.add(c);
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}