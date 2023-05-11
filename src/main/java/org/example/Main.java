package org.example;


import java.util.*;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        List<Integer> allGroupSizes = new ArrayList<>();
        for(int i = 0 ; i < groupSizes.length ; ++i){
            if(allGroupSizes.contains(groupSizes[i]) == false){
                allGroupSizes.add(groupSizes[i]);
            }
        }

        Collections.sort(allGroupSizes);

        List<List<Integer>> groups = new ArrayList<>();

        for(int i = 0 ; i < allGroupSizes.size() ; ++i){
            int currentGroupSize = allGroupSizes.get(i);
            groups.add(new ArrayList<>());
            for(int j = 0 ;j < groupSizes.length ; ++j){
                if(groupSizes[j] == currentGroupSize){
                    if(groups.get(groups.size() - 1).size() >= currentGroupSize){
                        groups.add(new ArrayList<>());
                    }
                    groups.get(groups.size() - 1).add(j);
                }
            }
        }

        return groups;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {3,3,3,3,3,1,3};
        System.out.println(s.groupThePeople(arr));


    }
}