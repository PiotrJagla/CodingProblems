package org.example;

import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2)
            return 0;

        Arrays.sort(nums);


        int maxGap = 0;
        for (int i = 0; i < nums.length - 1 ;i++) {
            maxGap = Math.max(maxGap, Math.abs(nums[i] - nums[i+1]) );
        }
        return maxGap;
    }
}

public class Main {






    public static void main(String[] args) {



    }
}