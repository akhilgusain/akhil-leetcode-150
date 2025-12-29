package OneDDynamicProgramming;

class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr; // assigning curr to temp
            curr = prev + curr; // assigning prev and curr to curr 
            prev = temp; // assigning old curr to current prev
        }
        return curr;
    }
}
