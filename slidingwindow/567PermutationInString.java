package SlidingWindow;

//Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // s1 should not be greater than s2
        if(s1.length() > s2.length()) return false;
        // we will make two hashmap/arraymap and then use sliding window in s2
        // first lets make arraymap for s1 and s2. till s1 length the loop runs since its the window size
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for(int i = 0; i < s1.length(); i++){
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++; 
        }

        // now the map is made lets traverse through the string using sliding window
        for(int i=0; i < s2.length() - s1.length(); i++){
            if(sameArrayOrNot(s1Map, s2Map)) return true;
            s2Map[s2.charAt(i + s1.length()) - 'a' ]++; // add new character to window
            s2Map[s2.charAt(i) - 'a']--;// remove old character from window
        }

        return sameArrayOrNot(s1Map, s2Map);

    }
    private boolean sameArrayOrNot(int[] s1Map, int[] s2Map){
        for(int i=0; i < 26; i++){
            if(s1Map[i] != s2Map[i]) return false; 
        }
        return true;
    }
}