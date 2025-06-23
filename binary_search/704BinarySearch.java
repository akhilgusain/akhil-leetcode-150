package binary_search;

class Solution {
    public int search(int[] nums, int target) {
        // you know how to do this already
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while(left <= right){
            mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = left + 1;
            }
            else if(nums[mid] > target){
                right = right - 1;
            }
        }
        return -1;
    }
}
