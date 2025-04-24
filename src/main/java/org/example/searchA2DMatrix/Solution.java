package org.example.searchA2DMatrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length -1;

        int rowMid = rowStart + (rowEnd - rowStart) / 2;

        int colMid = colStart + (colEnd - colStart) / 2;

        Integer targetRow = null;

        while (matrix[rowMid][0] != target) {
            if (target > matrix[rowMid][0]) {
                if (rowEnd == rowStart) {
                    targetRow = rowStart;
                    break;
                }

                if (rowEnd - rowStart == 1) {
                    if (target >= matrix[rowEnd][0]) {
                        targetRow = rowEnd;
                        break;
                    } else {
                        targetRow = rowStart;
                        break;
                    }
                }
                rowStart = rowMid;
            } else {
                if (rowEnd == rowStart || rowEnd - rowStart == 1) {
                    if (rowStart > 0) {
                        targetRow = rowStart - 1;
                        break;
                    } else {
                        return false;
                    }
                }

                rowEnd = rowMid;
            }

            rowMid = rowStart + (rowEnd - rowStart) / 2;
        }

        if (targetRow == null) {
            targetRow = rowMid;
        }

        while (matrix[targetRow][colMid] != target) {
            if (target > matrix[targetRow][colMid]) {
                if (colEnd == colStart) {
                    return false;
                }

                if (colEnd - colStart == 1) {
                    return target == matrix[targetRow][colEnd] ? true : false;
                }
                colStart = colMid;

            } else {
                if (colEnd == colStart || colEnd - colStart == 1) {
                    return false;
                }

                colEnd = colMid;
            }

            colMid = colStart + (colEnd - colStart) / 2;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = new int[][]{
                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}
        };
        System.out.println(solution.searchMatrix(matrix, 3));
    }
}
