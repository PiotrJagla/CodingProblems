package org.example;


import java.sql.PreparedStatement;
import java.util.*;

class Solution {
    public int firstMissingPositive(int[] nums) {


        HashSet<Integer> map = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            map.add(nums[i]);
        }

        for (int smallestPositiveInteger = 1; ; ++smallestPositiveInteger) {
            if(map.contains(smallestPositiveInteger) == false){
                return smallestPositiveInteger;
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr = {27,5,24,17,27,4,23,16,6,26,13,17,21,3,9,10,28,26,4,10,28,2};
        int[] arr2 = {26,9,14,17,6,14,23,24,11,6,27,14,13,1,15,5,12,15,23,27,28,12};

        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        System.out.println(s.firstMissingPositive(arr));


    }
}