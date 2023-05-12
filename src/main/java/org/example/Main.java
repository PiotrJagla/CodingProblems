package org.example;


import java.sql.PreparedStatement;
import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int Xdirection = 1;
        int Ydirection = 0;

        int Xpos = 0;
        int Ypos = 0;

        int maxLeft = 0;
        int maxRight = matrix[0].length - 1;
        int maxUp = 1;
        int maxDown = matrix.length - 1;
        for(int i = 0 ; i < matrix.length * matrix[0].length ; ++i){
            result.add(matrix[Ypos][Xpos]);

            Xpos += Xdirection;
            Ypos += Ydirection;

            if(Xpos > maxRight && Xdirection == 1){
                Xdirection = 0;
                Ydirection = 1;
                Xpos--;
                Ypos += Ydirection;
                maxRight--;
            }
            else if(Xpos < maxLeft && Xdirection == -1){
                Xdirection = 0;
                Ydirection = -1;
                Xpos++;
                Ypos += Ydirection;
                maxLeft++;
            }
            else if(Ypos > maxDown && Ydirection == 1){
                Xdirection = -1;
                Ydirection = 0;
                Ypos--;
                Xpos += Xdirection;
                maxDown--;
            }
            else if(Ypos < maxUp && Ydirection == -1){
                Ydirection = 0;
                Xdirection = 1;
                Ypos++;
                Xpos += Xdirection;
                maxUp++;
            }


        }
        return result;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr = {27,5,24,17,27,4,23,16,6,26,13,17,21,3,9,10,28,26,4,10,28,2};
        int[] arr2 = {26,9,14,17,6,14,23,24,11,6,27,14,13,1,15,5,12,15,23,27,28,12};

        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        System.out.println(s.spiralOrder(matrix));


    }
}