package org.example.setMatrixZeroes;

import java.util.Arrays;

public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean setFirstRowToZero = false;
        boolean setFirstColumnToZero = false;

        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0){
                setFirstColumnToZero = true;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0){
                setFirstRowToZero = true;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int m = 1; m < matrix.length; m++) {
            if (matrix[m][0] == 0) {
                for (int n = 0; n < matrix[0].length; n++) {
                    matrix[m][n] = 0;
                }
            }
        }

        for (int n = 1; n < matrix[0].length; n++) {
            if (matrix[0][n] == 0) {
                for (int m = 0; m < matrix.length; m++) {
                    matrix[m][n] = 0;
                }
            }
        }

        if (setFirstRowToZero) {
            for (int n = 0; n < matrix[0].length; n++) {
                matrix[0][n] = 0;
            }
        }

        if(setFirstColumnToZero){
            for (int m = 0; m < matrix.length; m++) {
                matrix[m][0] = 0;
            }
        }
    }



    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] matrix = new int[][]{{0,1}};
        solution.setZeroes(matrix);
        Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
    }
}
