package twopointers;

/*
Input:
height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]

maxLeft:  [0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3]
maxRight: [3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1, 0]

min(L, R):[0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 1, 0]

Water trapped at each index:
water[i] = min(maxLeft[i], maxRight[i]) - height[i]

Note:
min(L, R) - height[i] >= 0
*/


class Solution {
    public int trap(int[] height) {
        // left and right pointer would be from 0 and length - 1 respectively
        // leftMax we have to find and also rightMax 
        int left = 0;
        int right = height.length - 1;
        int total = 0;
        int leftMax = height[0], rightMax = height[right];
        // whichever side has lower height we will work on that. since left is smaller in the above example so we shift to right
        while(left < right){
            if(height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                if(leftMax - height[left] > 0){ // we can store the water
                    total += leftMax - height[left];
                }
                left++;
            }
            else{
                rightMax = Math.max(rightMax, height[right]);
                if(rightMax - height[right] > 0){
                    total += rightMax - height[right];
                }
                right--;
            }
        }
        return total;
    }
}
