package stacks;

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // since we have to worry about day i.e why use index in stacks
        // we will add the temperature's day i.e index in stacks
        // and if we find that current temp is greater than top of stack then we will pop it and add to result
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer>stack = new Stack<>();
        for(int i=0; i < n; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }
        return ans;
    }
}
