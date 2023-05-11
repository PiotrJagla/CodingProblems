package org.example;


import java.util.*;

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int result = 0;

        int minPlantTime = Integer.MAX_VALUE;
        int minPlantTimeIndex = -1;
        for(int i = 0 ; i < plantTime.length ; ++i){
            if(plantTime[i] < minPlantTime){
                minPlantTime = plantTime[i];
                minPlantTimeIndex = i;
            }
        }
        List<Integer> plantingOrder = new ArrayList<>();
        plantingOrder.add(minPlantTimeIndex);

        for(int plant = 1 ; plant < plantTime.length ; ++plant){

            int nextPlantIndex = -1;
            int currentBestScore = 100;
            for(int i = 0 ; i < plantTime.length ; ++i){
                if(plantingOrder.contains(i))
                    continue;

                if(plantTime[i] - growTime[i] < currentBestScore){
                    nextPlantIndex = i;
                    currentBestScore = plantTime[i] - growTime[i];
                }


            }
            plantingOrder.add(nextPlantIndex);
        }





        return result;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,2,3,2};
        int[] arr2 = {2,1,2,1};
        System.out.println(s.earliestFullBloom(arr, arr2));


    }
}