package strings;

class Solution {
    public boolean isAnagram(String s, String t) {
        // Check whether strings are equal or not
        if(s.length() != t.length()){
            return false; // not an anagram
        }

        int[] counterArray = new int[26];
        // we define an array where all characters frequency would be calculated for both strings s and t
        // so for s it will be incremented and t it will be decremented. 
        // if at the end the counterArray contains all zeros then it means both strings are anagram

        for(int i = 0; i < s.length(); i++){
            counterArray[s.charAt(i) - 'a']++; // for s string characters increment count
            counterArray[t.charAt(i) - 'a']--; // for t string character decrement count
        }

        // Now we will check if a non zero value is present that means its not anagram
        for(int num : counterArray){
            if(num != 0) return false;
        }
        return true;
    }
}