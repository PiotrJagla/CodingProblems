package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;


class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        if(nums[0] == 0){
            return false;
        }

        for (int i = 0; ; ) {
            int maxJump = nums[i];

            if(i + nums[i] >= nums.length - 1)
                return true;

            int maxNextJumpIndex = i + 1;
            int maxNextJump = 0;
            for(int j = i + 1 ; j <= maxJump + i ; ++j){
                if(maxNextJump <= nums[j]){
                    int oneJumpFurther = findMaxJump(nums,j);
                    if(oneJumpFurther + nums[oneJumpFurther] >= nums.length - 1)
                        return true;
                    if(j != maxJump + i && nums[oneJumpFurther] == 0)
                        continue;
                    maxNextJumpIndex = j;
                    maxNextJump = nums[j];
                }
            }
            i = maxNextJumpIndex;

            if(nums[maxNextJumpIndex] == 0)
                return false;
        }
    }

    private int findMaxJump(int nums[], int startIndex){
        int maxNextJumpIndex = startIndex + 1;
        if(nums[startIndex] + startIndex >= nums.length - 1)
            return nums.length - 1;
        if(nums[startIndex] == 0){
            return startIndex;
        }
        if(maxNextJumpIndex >= nums.length-1)
            return startIndex;

        int maxJump = nums[startIndex];
        for(int j = startIndex + 2 ; j <= maxJump + startIndex && j <= nums.length - 2 ; ++j){
            if(nums[maxNextJumpIndex] <= nums[j]){
                maxNextJumpIndex = j;
            }
        }
        return maxNextJumpIndex;
    }
}



public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] arr = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int[] arrr = {1,1,2,2,0,1,1};
        System.out.println(s.canJump(arrr));
    }
}