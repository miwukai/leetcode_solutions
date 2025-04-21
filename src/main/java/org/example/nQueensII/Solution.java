package org.example.nQueensII;

class Solution {
    public int totalNQueens(int n) {

        int[][] board = new int[n][n];

        int result = 0;

        result += setQueen(board, 0);

        return result;

    }

    int setQueen(int[][] board, int i) {

        int len = board.length;

        int result = 0;

        for (int j = 0; j < len; j++) {

            boolean valid = true;

            if (board[i][j] == 0) {
                board[i][j] = i + 1;
            } else {
                valid = false;
            }

            if (valid) {
                for (int n = 0; n < len; n++) {
                    if (n != j) {
                        if (board[i][n] == 0)
                        board[i][n] = i + 1;
                    }
                }
            }

            if (valid) {
                for (int m = 0; m < len; m++) {
                    if (m != i) {
                        if (board[m][j] == 0)
                        board[m][j] = i + 1;

                    }
                }
            }

            if (valid) {
                for (int x = 1; x <= Math.min(i, j); x++) {
                    if (board[i - x][j - x] == 0)
                    board[i - x][j - x] = i + 1;
                }
            }

            if (valid) {
                for (int x = 1; x <= Math.min(len - i - 1, len - 1 - j); x++) {
                    if (board[i + x][j + x] == 0)
                    board[i + x][j + x] = i + 1;
                }
            }

            if (valid) {
                for (int x = 1; x <= Math.min(i, len - 1 - j); x++) {
                    if (board[i - x][j + x] == 0)
                    board[i - x][j + x] = i + 1;
                }
            }

            if (valid) {
                for (int x = 1; x <= Math.min(len - i - 1, j); x++) {
                    if (board[i + x][j - x] == 0)
                    board[i + x][j - x] = i + 1;
                }
            }

            if (valid) {
                if (i == len - 1) {
                    result += 1;
                } else {
                    result += setQueen(board, i + 1);
                }
            }

            for (int y = 0; y < len; y++) {
                for (int z = 0; z < len; z++) {
                    if (board[y][z] == i + 1) {
                        board[y][z] = 0;
                    }
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4; // Example input
        int result = solution.totalNQueens(n);
        System.out.println("Total solutions for " + n + " queens: " + result);
    }
}
