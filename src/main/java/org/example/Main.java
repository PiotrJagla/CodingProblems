package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;


class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int healthLost = 0;
        int minHealth = dungeon[0][0];

        int Xpos = 0;
        int Ypos = 0;
        while(Xpos != dungeon[0].length - 1 || Ypos != dungeon.length - 1){
            healthLost += dungeon[Ypos][Xpos];
            if(healthLost < minHealth){
                minHealth = healthLost;
            }

            if(Xpos == dungeon[0].length - 1){
                Ypos++;
            }
            else if(Ypos == dungeon.length - 1){
                Xpos++;
            }
            else if(dungeon[Ypos + 1][Xpos] >= dungeon[Ypos][Xpos + 1]){
                Ypos++;
            }
            else if(dungeon[Ypos + 1][Xpos] < dungeon[Ypos][Xpos + 1]){
                Xpos++;
            }


        }

        healthLost += dungeon[Ypos][Xpos];
        if(healthLost < minHealth){
            minHealth = healthLost;
        }

        if(minHealth > 0)
            return 1;

        return Math.abs(minHealth) + 1;
    }
}

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] arr = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(s.calculateMinimumHP(arr));
    }
}