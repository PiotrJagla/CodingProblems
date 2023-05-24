package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length - 1, memo);
    }

    private int rob(int[] nums, int index, int[] memo){
        if(index < 0)
            return 0;

        if(memo[index] >= 0)
            return memo[index];

        int res = Math.max(rob(nums, index-2, memo) + nums[index], rob(nums, index - 1, memo));
        memo[index] = res;
        return res;
    }
}

public class Main {


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,2,3,1};
        int[][] arrr = {{1,3,1},{1,5,1},{4,2,1}};

        System.out.println(s.rob(arr));
    }

}