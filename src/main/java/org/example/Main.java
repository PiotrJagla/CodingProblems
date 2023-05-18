package org.example;

import javax.swing.plaf.InsetsUIResource;
import java.util.*;


class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            int[][] res ={{intervals[0][0], intervals[0][1]}};
            return res;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int start = 0;
        int end = 1;
        List<List<Integer>> mergedIntervals = new ArrayList<>();
        List<Integer> firstInterval = new ArrayList<>();
        firstInterval.add(intervals[0][0]);
        firstInterval.add(intervals[0][1]);
        mergedIntervals.add(firstInterval);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][end] >= intervals[i][start] && intervals[i - 1][start] <= intervals[i][end]){
                int x = mergedIntervals.size() - 1;
                int mergedStart = Math.min(intervals[i - 1][start], intervals[i][start]);
                int mergedEnd = Math.max(intervals[i][end], intervals[i - 1][end]);
                mergedIntervals.get(x).set(0, mergedStart);
                mergedIntervals.get(x).set(1, mergedEnd);
                intervals[i][0] = mergedStart;
                intervals[i][1] = mergedEnd;
            }
            else{
                List<Integer> interval = new ArrayList<>();
                interval.add(intervals[i][start]);
                interval.add(intervals[i][end]);
                mergedIntervals.add(interval);
            }
        }

        int[][] result = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            result[i][0] = mergedIntervals.get(i).get(0);
            result[i][1] = mergedIntervals.get(i).get(1);
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] arr = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[] arrr = {1,1,2,2,0,1,1};
        System.out.println(s.merge(arr));
    }
}