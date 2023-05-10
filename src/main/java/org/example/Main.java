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

        int maxNextOccurrence = 0;
        int lastPartition = -1;
        for(int i = 0 ; i < s.length() ; ++i){

            int currentCharLastOccurrence = charToLastOccurrence.get(s.charAt(i));
            maxNextOccurrence= Math.max(maxNextOccurrence, currentCharLastOccurrence);
            if(maxNextOccurrence == i){
                result.add(i - lastPartition);
                lastPartition = i;
                maxNextOccurrence = 0;

            }

        }
        return result;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {2,1,3,4,4};
        System.out.println(s.partitionLabels("ababcbacadefegdehijhklij"));


    }
}