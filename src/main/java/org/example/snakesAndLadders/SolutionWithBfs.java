package org.example.snakesAndLadders;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SolutionWithBfs {
    public int snakesAndLadders(int[][] board) {
        int len = board.length;

        Set<Integer> visited = new HashSet<>();

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{1, 0});

        visited.add(1);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i = 1; i <= 6; i++) {
                int nextSquare = cur[0] + i;

                int[] rowAndCol = getRowCol(nextSquare, len);

                int row = rowAndCol[0];

                int col = rowAndCol[1];

                if(board[row][col] != -1) {
                    nextSquare = board[row][col];
                }

                if(nextSquare == len * len){
                    return cur[1] + 1;
                }

                if(!visited.contains(nextSquare)) {
                    visited.add(nextSquare);
                    queue.offer(new int[]{nextSquare, cur[1] + 1});
                }
            }
        }

        return -1;

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
        SolutionWithBfs solution = new SolutionWithBfs();
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        System.out.println(solution.snakesAndLadders(board));
    }
}
