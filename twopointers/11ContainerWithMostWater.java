package TwoPointers;

class Solution {
    public int maxArea(int[] height) {
        // we will use two pointer approach here
        // first pointer at starting and second pointer at last
        // the tower with min height will contribute to area of container in water
        int first = 0;
        int last = height.length - 1;
        int maxArea = 0;
        
        while(first < last){
            maxArea = Math.max(maxArea, (last - first) * Math.min(height[first], height[last]));
            if(height[first] > height[last]){
                last--;
            }
            else{
                first++;
            }
        }
        return maxArea;
    }
}
