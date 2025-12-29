package BitManipulation;

class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1); // left shift makes space, n&1 picks the LSB and | adds
            n >>= 1; // right shifting gives next bit to process
        }
        return result;
    }
}
