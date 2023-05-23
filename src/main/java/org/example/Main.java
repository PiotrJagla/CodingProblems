package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];



        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length -1; j >= 0; j--) {
                int down = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                if(i + 1 < grid.length){
                    down = dp[i + 1][j];
                }
                if(j+1 < grid[0].length){
                    right = dp[i][j + 1];
                }

                dp[i][j] = grid[i][j];

                if(down != Integer.MAX_VALUE || right != Integer.MAX_VALUE){
                    dp[i][j] += Math.min(right, down);
                }

            }
        }

        return dp[0][0];
    }
}



public class Main {


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {10,22};
        int[][] arrr = {{1,3,1},{1,5,1},{4,2,1}};

        System.out.println(s.minPathSum(arrr));
    }

}