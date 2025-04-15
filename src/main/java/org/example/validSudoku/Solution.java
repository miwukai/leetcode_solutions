package org.example.validSudoku;

import java.util.HashMap;
import java.util.Map;

public class Solution {
//    public boolean isValidSudoku(char[][] board) {
//        Map<String, Character[]> m = new HashMap();
//
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (board[i][j] != '.') {
//                    Character[] row = m.getOrDefault("row" + i, new Character[9]);
//
//                    int index = board[i][j] - '1';
//
//                    if (row[index] != null && board[i][j] == row[index]) {
//                        return false;
//                    }
//                    row[index] = board[i][j];
//                    m.put("row" + i, row);
//
//                    Character[] column = m.getOrDefault("column" + j, new Character[9]);
//
//                    if (column[index] != null && board[i][j] == column[index]) {
//                        return false;
//                    }
//                    column[index] = board[i][j];
//                    m.put("column" + j, column);
//
//                    Character[] square = m.getOrDefault("square" + i / 3 + j / 3, new Character[9]);
//                    if (square[index] != null && board[i][j] == square[index]) {
//                        return false;
//                    }
//                    square[index] = board[i][j];
//                    m.put("square" + i / 3 + j / 3, square);
//                }
//            }
//        }
//
//        return true;
//    }

    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] columns = new int[9];
        int[] boxes = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                int num = board[i][j] - '1'; // Convert '1'-'9' to 0-8
                int mask = 1 << num;         // Create bitmask for the number
                int boxIndex = (i / 3) * 3 + j / 3;

                // Check if the number is already set in the row, column, or box
                if ((rows[i] & mask) != 0 || (columns[j] & mask) != 0 || (boxes[boxIndex] & mask) != 0) {
                    return false;
                }

                // Mark the number in the row, column, and box
                rows[i] |= mask;
                columns[j] |= mask;
                boxes[boxIndex] |= mask;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println( 1 << 8);

        Solution solution = new Solution();
        System.out.println(solution.isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }
}
