package binary_search;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // consider the matrix as 1d array because its row are sorted 
        // also the last element of each row is less than first element of next row
        // so we can imagine stretching outward the array and making it 1d array
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m*n - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            int midValue = matrix[mid/n][mid%n];
            if(target == midValue){
                return true;
            }
            else if(target < midValue){
                right = mid - 1;
            }
            else if(target > midValue){
                left = mid + 1;
            }
        }
        return false;
    }
}