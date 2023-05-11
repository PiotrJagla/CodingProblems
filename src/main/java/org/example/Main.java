package org.example;


import java.util.*;

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int result = 0;

        for(int i = 0 ; i < plantTime.length ; ++i){
            result += plantTime[i];
        }

        for(int i = 0 ; i < growTime.length ; ++i){
            int smallestIndex = i;
            for(int j = i + 1 ; j < growTime.length  ; ++j){
                if(growTime[smallestIndex] > growTime[j]){
                    smallestIndex = j;
                }
            }
            int temp = growTime[smallestIndex];
            growTime[smallestIndex] = growTime[i];
            growTime[i] = temp;
        }
        result += growTime[0];

        return result;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {27,5,24,17,27,4,23,16,6,26,13,17,21,3,9,10,28,26,4,10,28,2};
        int[] arr2 = {26,9,14,17,6,14,23,24,11,6,27,14,13,1,15,5,12,15,23,27,28,12};
        System.out.println(s.earliestFullBloom(arr, arr2));


    }
}