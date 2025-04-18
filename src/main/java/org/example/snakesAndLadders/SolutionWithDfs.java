package org.example.snakesAndLadders;

import java.util.HashSet;
import java.util.Set;

public class SolutionWithDfs {
    int minTotalSteps = Integer.MAX_VALUE;

    public int snakesAndLadders(int[][] board) {
        int len = board.length;

        Set<Integer> visited = new HashSet<>();

        return findNextSquare(board, 1, len, 0, visited);

    }

    int findNextSquare(int[][] board, int currSquare, int len, int step, Set<Integer> visited) {
        if (!visited.contains(currSquare)) {
            visited.add(currSquare);
        } else {
            return -1;
        }

        if (currSquare >= Math.pow(len, 2)) {
            visited.remove(currSquare);
            return step;
        } else {

            step++;

            if (step == minTotalSteps) {
                visited.remove(currSquare);
                return step;
            }

            int maxSquareThisTurn = Math.min(currSquare + 6, (int) Math.pow(len, 2));

            int maxTotalStep = -1;
           for (int j = currSquare + 1; j <= maxSquareThisTurn; j++) {
               int totalStep;

                if (j == Math.pow(len, 2)) {
                    visited.remove(currSquare);
                    return step;
                }

                int[] rowCol = getRowCol(j, len);

                if (board[rowCol[0]][rowCol[1]] != -1) {
                    totalStep = findNextSquare(board, board[rowCol[0]][rowCol[1]], len, step, visited);
                } else {
                    totalStep = findNextSquare(board, j, len, step, visited);
                }

                if (totalStep != -1) {
                    minTotalSteps = Math.min(totalStep, minTotalSteps);
                }

                maxTotalStep = Math.max(maxTotalStep, totalStep);
            }

            visited.remove(currSquare);

            return maxTotalStep == -1 ? -1 : minTotalSteps;

        }
    }

    int[] getRowCol(int square, int len) {
        int m = square % len;
        int r;
        int c;

        if (m == 0) {
            r = len - square / len;
            c = ((len - r) % 2 == 1) ? len - 1 : 0;
        } else {
            r = len - square / len - 1;
            c = ((len - r) % 2 == 1) ? m - 1 : len - m;
        }

        return new int[]{r, c};
    }

    public static void main(String[] args) {
        SolutionWithDfs solution = new SolutionWithDfs();
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}

//                {-1, 10, -1, 15, -1},
//                {-1, -1, 18, 2, 20},
//                {-1, -1, 12, -1, -1},
//                {2, 4, 11, 18, 8},
//                {-1, -1, -1, -1, -1}

//                {1, 1, -1},
//                {1, 1, 1},
//                {-1, 1, 1}

//                {2, -1, -1, -1, -1},
//                {-1, -1, -1, -1, -1},
//                {-1, -1, -1, -1, -1},
//                {-1, -1, -1, -1, -1},
//                {-1, -1, -1, -1, -1}
        };
        System.out.println(solution.snakesAndLadders(board));
    }
}
