package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length == 0){
            return new int[][]{{newInterval[0], newInterval[1]}};
        }

        List<int[]> result = new ArrayList<>();

        if(newInterval[1] < intervals[0][0]){
            result.add(newInterval);
        }

        for (int i = 0; i < intervals.length; i++) {
               if(intervals[i][1] < newInterval[0]){
                   result.add(intervals[i]);
               }
               else if(newInterval[0] > intervals[i][0] && newInterval[0] <= intervals[i][1]){
                   int[] toAdd = new int[]{intervals[i][0], Math.max(newInterval[1], intervals[i][1]) };
                   result.add(toAdd);
               } else if (newInterval[1] >= intervals[i][0]) {
                   int[] updated;
                   if (result.isEmpty()) {
                       result.add(new int[]{ Math.min(newInterval[0], intervals[i][0]), Math.max(newInterval[1], intervals[i][1]) });
                   } else {
                       updated = new int[]{result.get(result.size() - 1)[0], Math.max(intervals[i][1], newInterval[1]) };
                       result.set(result.size() - 1, updated);
                   }


               } else if (newInterval[1] < intervals[i][0]) {
                   result.add(intervals[i]);
               }


        }

        if(newInterval[0] > intervals[intervals.length - 1][1]){
            result.add(newInterval);
        }

        return result.toArray(new int[result.size()][2]);
    }
}
public class Main {


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {7,16};
        int[][] arrr = {{0,5},{9,12}};

        System.out.println(Arrays.deepToString(s.insert(arrr,arr)));
    }

}