package twodimensional_dynamicprogramming;

import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        int[] row = new int[n];
        Arrays.fill(row, 1); // Initialize the last row with 1s since 
        // there's only one way to reach the destination from there.

        for (int i = 0; i < m - 1; i++) {
            int[] newRow = new int[n];
            Arrays.fill(newRow, 1);
            for (int j = n - 2; j >= 0; j--) {
                // except for the last column, each cell is the sum of the cell
                // to the right and the cell below it.
                newRow[j] = newRow[j + 1] + row[j];
            }
            row = newRow;
        }
        return row[0]; // The top-left cell contains the total unique paths.
    }
}
