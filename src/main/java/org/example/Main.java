package org.example;


import java.util.*;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());
        int currentPartition=0;
        boolean[] visitedNumber = new boolean[nums.length];
        Arrays.fill(visitedNumber, false);
        for(int i = 0 ; i < nums.length ; ++i){
            if(visitedNumber[i])
                continue;
            for(int j = i ; j < nums.length ; ++j){
                if(visitedNumber[j] == false && result.get(result.size() - 1).contains(nums[j]) == false){
                    result.get(result.size() - 1).add(nums[j]);
                    visitedNumber[j] = true;
                }
            }
            result.add(new ArrayList<>());
        }

        result.removeIf(c -> c.isEmpty());

        return result;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,3,4,1,2,3,1};
        System.out.println(s.findMatrix(arr));


    }
}