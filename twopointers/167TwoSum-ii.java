package twopointers;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // since array is already sorted we can use two pointer technique
        int start = 0;
        int end = numbers.length - 1;
        while(start < end){
            int sum = numbers[start] + numbers[end];
            if(sum == target){
                return new int[]{start + 1, end + 1};
            }
            else if(sum > target){
                end--;
            }
            else if(sum < target){
                start++;
            }
        }
        return new int[]{};
    }
}