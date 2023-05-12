package org.example;


import java.sql.PreparedStatement;
import java.util.*;

class Solution {
    public int trap(int[] height) {
        int result = 0;

        int maxValueIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if(height[maxValueIndex] < height[i]){
                maxValueIndex = i;
            }
        }

        for (int i = 1; i < height.length - 1; i++) {

            int highestToTheLeft = 0;
            if(maxValueIndex < i){
                highestToTheLeft = height[maxValueIndex];
            }
            else{
                highestToTheLeft = Arrays.stream(Arrays.copyOfRange(height, 0, i)).max().getAsInt();
            }

            int highestToTheRight = 0;
            if(maxValueIndex > i){
                highestToTheRight = height[maxValueIndex];
            }
            else{
                highestToTheRight = Arrays.stream(Arrays.copyOfRange(height, i+1, height.length)).max().getAsInt();
            }

            int minOfMaxes = Math.min(highestToTheRight, highestToTheLeft);
            result += (minOfMaxes - height[i] > 0) ? minOfMaxes - height[i] : 0;
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

        System.out.println(s.trap(arr));


    }
}