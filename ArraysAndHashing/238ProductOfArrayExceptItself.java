package arraysandhashing;

import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // we have to create prefix, postfix array then multiply both to get answer array
        // would take two iteration i.e left to right and then right to left
        // more better approach would be to do it in single array
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int pre = 1, post = 1;
        // going left to right
        for(int i=0; i < nums.length; i++){
            result[i] = result[i] * pre;
            pre = nums[i] * pre;
        }
        // going right to left
        for(int i=nums.length - 1; i >=0 ; i--){
            result[i] = result[i] * post;
            post = post * nums[i];
        }
        return result;
    }
}
