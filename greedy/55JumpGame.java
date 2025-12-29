package greedy;

class Solution {
    public boolean canJump(int[] nums) {
       // [2,3,1,1,4]
       int reachable = 0;
       // the approach here is that we find out the max reach via reachable variable
       // 
       for(int i = 0; i < nums.length; i++){
        if(i > reachable) return false; // this means the position is greater than farthest we can go.
        reachable = Math.max(reachable, i + nums[i]);
        if(reachable >= nums.length) return true;
       }
       return true;
    }
}
