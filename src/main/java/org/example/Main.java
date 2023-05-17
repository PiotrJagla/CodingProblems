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
            for(int j = i + 2 ; j <= maxJump + i ; ++j){
                if(nums[maxNextJumpIndex] <= nums[j]){
                    maxNextJumpIndex = j;
                }
            }
            i = maxNextJumpIndex;

            if(nums[maxNextJumpIndex] == 0)
                return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] arr = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int[] arrr = {4,2,0,0,1,1,4,4,4,0,4,0};
        System.out.println(s.canJump(arrr));
    }
}