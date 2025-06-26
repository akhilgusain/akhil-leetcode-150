package binary_search;
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // the number of k if increased then h will decrease and vice versa.
        // we can list all values of h and k then can use binary search to find min value of k for required h
        //       left                    right
        //  k -> 1  2  3  4 5 6 7 8 9 10 11
        //  h -> 28 14 10 8 8 6 5 5 5 5  4
        // initialize left and right pointer
        int left = 0, right = 0;
        for(int pile : piles){
            right = Math.max(right, pile); // maximum of all piles
        }

        while(left < right){
            int mid = left + (right - left)/2;
            // for particular k speed lets calculate the no of hours
            if(canFinish(piles, mid, h)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
    private static boolean canFinish(int[] piles, int speed, int h){
        int hours = 0;
        for(int pile : piles){
            hours += Math.ceil((double)pile/speed);
        }
        return hours <= h;
    }
}