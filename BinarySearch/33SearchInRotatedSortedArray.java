package BinarySearch;

class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] <= nums[mid]){ //that means first half is sorted
                if(target < nums[left] || target > nums[mid]){ // target is outside the range of left and mid
                    // since target is on right half then
                    left = mid + 1;
                }
                else{ //target is in first half
                    right = mid - 1;
                }
            }
            else{ // that means second half is sorted
                if(target > nums[right] || target < nums[mid]){ // since target is in left half
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
