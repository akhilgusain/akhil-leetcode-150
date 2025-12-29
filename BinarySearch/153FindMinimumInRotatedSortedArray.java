package BinarySearch;

class Solution {
    public int findMin(int[] nums) {
        // if left = 0 and right = nums.length - 1
        // if its sorted i.e value at left < value of right then we have to return value at left
        // if value at left > value at right then the min value will be between left and right
        // ex : 11,13,15,17 then nums[left] < nums[right] then return nums[left]
        // ex : 3,4,5,1,2 here nums[left] > nums[right] that means the minimum value is somewhere between
        // so we increase left by mid + 1 and then left = 3 and then nums[left] < nums[right] hence right = mid 
        // i.e right = mid = left i.e 3 so return nums[3];
        int left = 0, right = nums.length - 1;

        // If the array is not rotated at all
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Minimum is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // Minimum is in the left half including mid
            else {
                right = mid;
            }
        }
        // At the end, left == right, pointing to the minimum element
        return nums[left];
    }
}
