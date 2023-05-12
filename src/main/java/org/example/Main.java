package org.example;


import java.sql.PreparedStatement;
import java.util.*;

class Solution {
    public int trap(int[] height) {
        if(height.length <= 2)
            return 0;

        int result = 0;

        int maxValueIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if(height[maxValueIndex] < height[i]){
                maxValueIndex = i;
            }
        }


        int rightSideMaxHeight = 0;
        int leftSideMaxHeight = 0;

        if(maxValueIndex > 1){
            rightSideMaxHeight = height[maxValueIndex];
            leftSideMaxHeight = height[0];
        }
        else if(maxValueIndex == 0){
            leftSideMaxHeight = height[maxValueIndex];
            rightSideMaxHeight = Arrays.stream(Arrays.copyOfRange(height, 2, height.length)).max().getAsInt();
        }
        else if(maxValueIndex == 1){
            leftSideMaxHeight = height[0];
            rightSideMaxHeight = Arrays.stream(Arrays.copyOfRange(height, 2, height.length)).max().getAsInt();
        }


        int nextRightSideIndexCheck = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int minOfMaxes = Math.min(leftSideMaxHeight, rightSideMaxHeight);
            result += (minOfMaxes - height[i] > 0) ? minOfMaxes - height[i] : 0;

            if(height[i] > leftSideMaxHeight){
                leftSideMaxHeight = height[i];
            }
            if(rightSideMaxHeight == height[i+1] && nextRightSideIndexCheck <= i){
                nextRightSideIndexCheck = i;
                for(int j = i+1 ; j < height.length ; ++j){
                    if(height[j] != rightSideMaxHeight){
                        nextRightSideIndexCheck = j - 2;
                        break;
                    }

                    if(j + 1 == height.length)
                        nextRightSideIndexCheck = j;
                }
                if(i+2 < height.length){
                    rightSideMaxHeight = Arrays.stream(Arrays.copyOfRange(height, i+2, height.length)).max().getAsInt();
                }
            }

        }

        return result;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr = {9,6,8,8,5,6,3};
        int[] arr2 = {26,9,14,17,6,14,23,24,11,6,27,14,13,1,15,5,12,15,23,27,28,12};

        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        System.out.println(s.trap(arr));


    }
}