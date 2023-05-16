package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;


class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        dp[dungeon.length-1][dungeon[0].length-1] = dungeon[dungeon.length-1][dungeon[0].length-1];

        for(int y = dungeon.length - 1 ; y >= 0 ; --y){
            for (int x = dungeon[0].length - 1; x >= 0; x--) {
                if(x == dungeon[0].length - 1 && y == dungeon.length - 1)
                    continue;

                int currentDungeon = dungeon[y][x];
                int downHpLoss = -99999;
                if(y + 1 < dungeon.length){
                    downHpLoss = Math.min(dp[y+1][x], 0);
                }
                int rightHpLoss = -99999;
                if(x + 1 < dungeon[0].length){
                    rightHpLoss = Math.min( dp[y][x+1], 0);
                }
                int res = currentDungeon + Math.max(rightHpLoss, downHpLoss);
                dp[y][x] = Math.min(res, 0);


            }
        }

        if(dp[0][0] > 0){
            return 1;
        }
        return Math.abs(dp[0][0]) + 1;
    }
}

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] arr = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(s.calculateMinimumHP(arr));
    }
}