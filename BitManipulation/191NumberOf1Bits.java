package BitManipulation;

class Solution {
    public int hammingWeight(int n) {
        var sumNo = 0;

        while(n != 0){
            sumNo++;
            n = n & (n-1);
         }

         return sumNo;
    }
}
