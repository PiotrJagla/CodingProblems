package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> charToLastOccurrence = new HashMap<>();
        for(int i =0 ; i < s.length() ; ++i){
            charToLastOccurrence.put(s.charAt(i), i);
        }

        int currentSliceIndex = 0;
        for(int i = 1 ; i <= s.length() ; ++i){
            boolean willPartition = true;
            for(int j = currentSliceIndex ; j < i ; ++j){

                if(charToLastOccurrence.get(s.charAt(j)) >= i){
                    willPartition = false;
                    break;
                }
            }
            if(willPartition){

                result.add(i - currentSliceIndex);

                currentSliceIndex = i;
            }
        }
        return result;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {2,1,3,4,4};
        System.out.println(s.partitionLabels("caedbdedda"));


    }
}