package BinarySearch;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // x : [0,3,5,6,11] 
        // y : [1,2,8,12,13,15]
        // total elements : 11 so total element in left partition would be (11 + 1)/2 => 6
        // we have to divide into two partition of size 2 and 4 initialy
        // i.e x partition : (start + ending)/2 and y partition : 6 - x partition
        // (x + y) Left Partition : 6
        // for finding median we are concerned with left side only 
        // for odd scenario we can just return last element of left side and for even the avg we can return

        // Left Partition                      Right Partition
        // 0 3                          |      5,6,11
        // 1,2,8,12                     |      13,15

        // 3 should be less than 13 and also 12 should be less than 5 since left partition should be less 
        // so we need to move 12 to right side and 5 to left side
        // (s + e) / 2 => (0 + 4)/2 => 2; so new start = 2 + 1 = 3 and ending = 4
        // so now x partition = (s + e)/2 => (3 + 4)/2 => 3 and y partition = 3
        // so partition would be like
        
        // 0,3,5                        |        6,11
        // 1,2,8                        |        12,13,15
        // 5 less than 12 is fine but 8 should be less than 6

        // so again s would be (s + e) / 2 hence (3+4)/2 => 3 and 3 + 1 = 4 so s and e = 4
        // so x partition needs (s + e)/2 => (4+4)/2 => 4 and y partition needs 2

        // 0,3,5,6                      |         11
        // 1,2                          |         8,12,13,15

        // now condition is satisfied since 6<8 and 2 < 11
        // from left select max value i.e 6 since its odd case so it is the median
        // edge case is -Infinity and Infinity as default value
        // for even scenario we have to take max from left and min from right and take avg of both
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int x = nums1.length;
        int y = nums2.length;
        int start = 0;
        int end = x;
        while(start <= end){
            int partX = (start + end)/2;
            int partY = (x+y+1)/2-partX;
            int xLeft = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int xRight = partX == x ? Integer.MAX_VALUE : nums1[partX];
            int yLeft = partY == 0 ? Integer.MIN_VALUE : nums2[partY- 1];
            int yRight = partY == y ? Integer.MAX_VALUE : nums2[partY];

            if(xLeft <= yRight && yLeft <= xRight){
                if((x+y)%2 == 0){
                    return ((double)Math.max(xLeft, yLeft) + Math.min(xRight, yRight))/2;
                }
                else{
                    return Math.max(xLeft, yLeft);
                }
            } //if ideal scenario is not there i.e leftpartition element is not less than right then :
            else if(xLeft > yRight){
                end = partX - 1;
            }
            else{
                start = partX + 1;
            }
        }
        return 0;
    }
}
