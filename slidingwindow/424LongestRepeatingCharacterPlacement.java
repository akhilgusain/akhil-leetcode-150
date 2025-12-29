package SlidingWindow;

class Solution {
    public int characterReplacement(String s, int k) {
        // if length - max occurence of a character > k then we dont have to check and increment left variable
        int[] occurence = new int[26]; //this array is used to set frequency of an uppercase character
        int left = 0;
        int maxOccurence = 0;
        int ans = 0;

        for(int right = 0; right < s.length(); right++){
            // increment and set maximum occuring characters
            maxOccurence = Math.max(maxOccurence, ++occurence[s.charAt(right) - 'A']);
            if(right - left + 1 - maxOccurence > k){ // ideal scenario : length - maximum occuring character <= k
                left++;
                occurence[s.charAt(left) - 'A']--;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
