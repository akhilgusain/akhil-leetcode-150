package onedimensional_dynamicprogramming;

class Solution {
    public String longestPalindrome(String s) {
        String longestPalindrome = "";

        for (int i = 0; i < s.length(); i++) {
            // Get the longest palindrome with center i (odd-length)
            String oddPalindrome = expandAroundCenter(s, i, i);
            // Get the longest palindrome with center between i and i + 1 (even-length)
            String evenPalindrome = expandAroundCenter(s, i, i + 1);

            // Update the longest palindrome if we find a longer one
            if (oddPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = oddPalindrome;
            }
            if (evenPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = evenPalindrome;
            }
        }

        return longestPalindrome;
    }

    // Function to expand around center and return the palindrome substring
    private String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // When the loop exits, left and right are one position beyond the palindrome bounds
        return s.substring(left + 1, right);
    }
}
