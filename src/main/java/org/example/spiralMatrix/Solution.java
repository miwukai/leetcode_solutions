package org.example.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int columnStart = 0;
        int columnEnd = matrix[0].length - 1;

        List<Integer> output = new ArrayList();

        while (true) {
            for (int j = columnStart; j <= columnEnd; j++) {
                output.add(matrix[rowStart][j]);
            }

            rowStart++;

            if (rowStart > rowEnd) break;

            for (int j = rowStart; j <= rowEnd; j++) {
                output.add(matrix[j][columnEnd]);
            }

            columnEnd--;

            if (columnEnd < columnStart) break;

            for (int j = columnEnd; j >= columnStart; j--) {
                output.add(matrix[rowEnd][j]);
            }

            rowEnd--;

            if (rowEnd < rowStart) break;

            for (int j = rowEnd; j >= rowStart; j--) {
                output.add(matrix[j][columnStart]);
            }

            columnStart++;

            if (columnStart > columnEnd) break;
        }

        return output;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
