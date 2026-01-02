package onedimensional_dynamicprogramming;

// class Solution {
//     public int rob(int[] nums) {
//         if (nums == null || nums.length == 0) {
//             return 0;
//         }

//         int even = 0;
//         int odd = 0;

//         for (int i = 0; i < nums.length; i++) {
//             if (i % 2 == 0) {
//                 even = Math.max(even + nums[i], odd);
//             } else {
//                 odd = Math.max(odd + nums[i], even);
//             }
//         }

//         return Math.max(even, odd);
//     }
// }

class Solution {
    public int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;
        // [rob1, rob2, n, n + 1, ...]
        for (int num : nums) {
            int temp = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}