package ArraysAndHashing;

import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // create hashset(i.e 9 in number) for rows, columns and boxes. find any
        // duplicate and return false, go through each entry
        // any box can be represented by r/3 + 3 + c/3
        int n = 9;

        HashSet<Character>[] row = new HashSet[n];
        HashSet<Character>[] column = new HashSet[n];
        HashSet<Character>[] box = new HashSet[n];

        for (int i = 0; i < n; i++) {
            row[i] = new HashSet<>();
            column[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }

        // after initializing all the hashmaps then we iterate through each element
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                char element = board[r][c];

                // check if position is filled with number
                if (element == '.')
                    continue;

                // check if it has duplicate in row
                if (row[r].contains(element))
                    return false;

                row[r].add(element);

                // check if it has duplicate in column
                if (column[c].contains(element))
                    return false;

                column[c].add(element);

                int boxId = (r / 3) * 3 + (c / 3);
                // check if it has duplicate in box
                if (box[boxId].contains(element))
                    return false;
                    
                box[boxId].add(element);
            }
        }
        return true;
    }
}
