package org.example.constructQuadTree;

public class Solution {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        if (grid.length == 1) {
            return new Node(grid[0][0] == 1 ? true : false, true, null, null, null, null);
        }
        return buildNode(grid, 0, grid.length - 1, 0, grid.length - 1);
    }

    public Node buildNode(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {
        if (rowEnd - rowStart == 1) {
            if (grid[rowStart][colStart] == grid[rowStart][colEnd]
                    && grid[rowStart][colEnd] == grid[rowEnd][colEnd]
                    && grid[rowEnd][colEnd] == grid[rowEnd][colStart]) {
                return new Node(grid[rowStart][colStart] == 1 ? true : false, true, null, null, null, null);
            } else {
                return new Node(true,
                        false,
                        new Node(grid[rowStart][colStart] == 1 ? true : false, true, null, null, null, null),
                        new Node(grid[rowStart][colEnd] == 1 ? true : false, true, null, null, null, null),
                        new Node(grid[rowEnd][colStart] == 1 ? true : false, true, null, null, null, null),
                        new Node(grid[rowEnd][colEnd] == 1 ? true : false, true, null, null, null, null));
            }
        }

        Node topLeft = buildNode(grid, rowStart, rowStart + (rowEnd - rowStart) / 2, colStart, colStart + (colEnd - colStart) / 2);
        Node topRight = buildNode(grid, rowStart, rowStart + (rowEnd - rowStart) / 2, colStart + (colEnd - colStart) / 2 + 1, colEnd);
        Node bottomLeft = buildNode(grid, rowStart + (rowEnd - rowStart) / 2 + 1, rowEnd, colStart, colStart + (colEnd - colStart) / 2);
        Node bottomRight = buildNode(grid, rowStart + (rowEnd - rowStart) / 2 + 1, rowEnd, colStart + (colEnd - colStart) / 2 + 1, colEnd);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val == topRight.val
                && topRight.val == bottomRight.val
                && bottomRight.val == bottomLeft.val) {
            return new Node(topLeft.val, true, null, null, null, null);
        } else {
            return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 0, 1, 1}
        };
        Node root = solution.construct(grid);
        System.out.println(root.val); // Output: false
        System.out.println(root.isLeaf); // Output: false
    }
}
