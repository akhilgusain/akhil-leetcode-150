package BitManipulation;

class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b; // carry bits
            a = a ^ b; // sum without carry
            b = carry << 1; // move carry to next bit
        }
        return a;
    }
}
