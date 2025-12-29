package stack;

import java.util.ArrayList;
import java.util.List;

// two conditions are there to be followed
// the sum of open and close should be equal to n
// open should be less than n
// close should be less than open
// i.e ex: for n = 2 then (()) ()() here we can see that in any point if we want to add open paranthesis
// we have to check it should not be greater than n.
// also for any close we can not exceed open brackets 

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans,"", 0, 0, n);
        return ans;
    }

    void backTrack(List<String> ans, String str, int open, int close, int max){
        if(str.length() == max * 2){
            ans.add(str);
            return;
        }
        if(open < max){
            backTrack(ans, str + "(", open + 1, close, max);
        }
        if(close < open){
            backTrack(ans, str + ")", open, close + 1, max);
        }
    }
}
