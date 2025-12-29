package greedy;

class Solution {
    public int jump(int[] nums) {
        int jumps = 0, reachable = 0, currentEnd = 0;
        for(int i = 0; i < nums.length - 1; i++){
            reachable = Math.max(reachable, i + nums[i]);
            
            if(i == currentEnd){
              jumps++;
              currentEnd = reachable;
            }

            if(currentEnd >= nums.length - 1)
            break;
        }
        return jumps;
        
    }
}
