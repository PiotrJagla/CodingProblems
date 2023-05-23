package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length == 0){
            return new int[][]{{newInterval[0], newInterval[1]}};
        }

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            result.add(intervals[i]);
        }

        if(newInterval[1] < intervals[0][0]){
            result.add(0, newInterval);
            return result.toArray(new int[result.size()][2]);
        }

        if(newInterval[0] > intervals[intervals.length - 1][1]){
            result.add(newInterval);
            return result.toArray(new int[result.size()][2]);
        }
        
        

        result = new ArrayList<>();

        int[] intervalToInsert = newInterval;
        for (int i = 0; i < intervals.length; i++) {

            if(intervals[i][0] > newInterval[1]){
                result.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    result.add(intervals[j]);
                }
                return result.toArray(new int[result.size()][2]);
            }
            else if(intervals[i][1] < newInterval[0]){
                result.add(intervals[i]);
            }
            else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }

        }

        result.add(newInterval);

        return result.toArray(new int[result.size()][2]);
    }
}
public class Main {


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {10,22};
        int[][] arrr = {{4,5},{9,12}, {14,18}, {20,26}, {30,37}};

        System.out.println(Arrays.deepToString(s.insert(arrr,arr)));
    }

}