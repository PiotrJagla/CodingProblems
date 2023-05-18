package org.example;

import javax.swing.plaf.InsetsUIResource;
import java.util.*;


class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> skyline = new ArrayList<>();

        HashSet<Integer> allPositions = new HashSet<>();
        for (int i = 0; i < buildings.length; i++) {
            int biggestHeightOnLeft = 0;
            for (int j = 0; j < buildings.length; j++) {
                if(buildings[i][0] >= buildings[j][0] && buildings[i][0] <= buildings[j][1] &&
                    buildings[j][2] > biggestHeightOnLeft){
                    biggestHeightOnLeft =buildings[j][2];
                }
            }

            if(biggestHeightOnLeft == buildings[i][2]){
                if(skyline.size() == 0){
                    if(allPositions.contains(buildings[i][0]) == false){
                        skyline.add(new ArrayList<>());
                        skyline.get(skyline.size() - 1).add(buildings[i][0]);
                        skyline.get(skyline.size() - 1).add(biggestHeightOnLeft);
                        allPositions.add(buildings[i][0]);
                    }

                }
                else{
                    if(biggestHeightOnLeft != skyline.get(skyline.size() - 1).get(1)){
                        if(allPositions.contains(buildings[i][0]) == false){
                            skyline.add(new ArrayList<>());
                            skyline.get(skyline.size() - 1).add(buildings[i][0]);
                            skyline.get(skyline.size() - 1).add(biggestHeightOnLeft);
                            allPositions.add(buildings[i][0]);
                        }

                    }
                }


            }


            int otherBiggestHeightOnRight = 0;
            int otherBiggestRightPos = 0;
            for (int j = 0; j < buildings.length; j++) {
                if(buildings[i][1] >= buildings[j][0] && buildings[i][1] <= buildings[j][1] &&
                        buildings[j][2] > otherBiggestHeightOnRight && i != j){
                    otherBiggestHeightOnRight = buildings[j][2];
                    otherBiggestRightPos = buildings[j][1];
                }
            }

            if(otherBiggestHeightOnRight == buildings[i][2] && otherBiggestRightPos == buildings[i][1]){
                otherBiggestHeightOnRight = 0;
            }

            if(otherBiggestHeightOnRight < buildings[i][2]){
                if(otherBiggestRightPos == buildings[i][1]){
                    otherBiggestHeightOnRight = 0;

                }
                if(allPositions.contains(buildings[i][1]) == false){
                    skyline.add(new ArrayList<>());
                    skyline.get(skyline.size() - 1).add(buildings[i][1]);
                    skyline.get(skyline.size() - 1).add(otherBiggestHeightOnRight);
                    allPositions.add(buildings[i][1]);
                }

            }


        }
        return skyline;
    }
}

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] arr = {{0,2,3},{2,5,3}};
        int[] arrr = {1,1,2,2,0,1,1};
        System.out.println(s.getSkyline(arr));
    }
}