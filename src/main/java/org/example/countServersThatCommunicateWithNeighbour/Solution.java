package org.example.countServersThatCommunicateWithNeighbour;

public class Solution {
    public int countServers(int[][] grid){
        int[][] checked = new int[grid.length][grid[0].length];

        int count = 0;

        for(int i = 0; i< grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    if(j < grid[0].length - 1){
                        if(grid[i][j+1] == 1){
                            if(checked[i][j] == 0){
                                checked[i][j] = 1;
                                count++;
                            }
                            checked[i][j+1] = 1;
                            count++;
                        }
                    }
                    if(i < grid.length - 1){
                        if(grid[i+1][j] == 1){
                            if(checked[i][j] == 0){
                                checked[i][j] = 1;
                                count++;
                            }
                            checked[i+1][j] = 1;
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}
