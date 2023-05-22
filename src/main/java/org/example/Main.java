package org.example;

import java.util.Arrays;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        else if(intervals.length == 1){

            if(newInterval[1]  < intervals[0][0]){
                return new int[][]{newInterval,intervals[0]};
            }
            else if(newInterval[0] > intervals[0][1]){
                return new int[][]{intervals[0], newInterval};
            }
            else{
                return new int[][]{{
                        Math.min(intervals[0][0], newInterval[0]), Math.max(newInterval[1], intervals[0][1])
                }};
            }


        }


        int[][] result = new int[1][1];
        for (int i = intervals.length - 1; i >= 0; i--) {
            if(intervals[i][0] <= newInterval[0] ){

                if(newInterval[0] > intervals[i][1] && newInterval[1] < intervals[i+1][0]){
                    //Interval dont overlap
                    result = new int[intervals.length + 1][2];
                    for (int j = 0; j < result.length; j++) {
                        if(i + 1 == j){
                            result[j][0] = newInterval[0];
                            result[j][1] = newInterval[1];
                        }
                        else if( j <= i){
                            result[j][0] = intervals[j][0];
                            result[j][1] = intervals[j][1];

                        }
                        else if(j > i){
                            result[j][0] = intervals[j][0];
                            result[j][1] = intervals[j][1];
                        }

                    }
                    return result;

                }
                else if(newInterval[1] < intervals[i + 1][0] && newInterval[0] <= intervals[i][1]){
                    //new interval overlap with only previous interval
                    result = new int[intervals.length][2];
                    for (int j = 0; j < result.length; j++) {
                        if(i == j){
                            result[j][0] = intervals[i][0];
                            result[j][1] = newInterval[1];
                        }
                        else if( j < i){
                            result[j][0] = intervals[j][0];
                            result[j][1] = intervals[j][1];

                        }
                        else if(j > i){
                            result[j][0] = intervals[j][0];
                            result[j][1] = intervals[j][1];
                        }

                    }
                    return result;
                }
                else if(newInterval[0] > intervals[i][1] && newInterval[1] >= intervals[i+1][0]){
                    //new interval dont overtlap with previous, but overlap with next interval/s
                    int intervalsOverlap = 1;
                    for (int j = i + 2; j < intervals.length; j++) {
                        if(newInterval[1] >= intervals[j][0]){
                            intervalsOverlap++;
                        }
                        else
                            break;
                    }

                    result = new int[intervals.length - intervalsOverlap + 1][2];
                    for (int j = 0; j < result.length; j++) {
                        if(i + 1 == j){
                            result[j][0] = newInterval[0];
                            result[j][1] = intervals[i + intervalsOverlap][1];

                        }
                        else if( j <= i){
                            result[j][0] = intervals[j][0];
                            result[j][1] = intervals[j][1];

                        }
                        else if(j > i){
                            result[j][0] = intervals[j + intervalsOverlap - 1][0];
                            result[j][1] = intervals[j +intervalsOverlap - 1][1];
                        }

                    }
                    return result;
                }
                else if(newInterval[0] <= intervals[i][1] && newInterval[1] >= intervals[i+1][0]){
                    //new interval overlap with previous and next interval
                    int intervalsOverlap = 1;
                    result = new int[intervals.length - intervalsOverlap][2];
                    for (int j = i + 2; j < intervals.length; j++) {
                        if(newInterval[1] >= intervals[j][0]){
                            intervalsOverlap++;
                        }
                        else
                            break;
                    }

                    for (int j = 0; j < result.length; j++) {
                        if(i == j){
                            result[j][0] = intervals[i][0];
                            result[j][1] = intervals[i + intervalsOverlap][1];
                        }
                        else if( j < i){
                            result[j][0] = intervals[j][0];
                            result[j][1] = intervals[j][1];

                        }
                        else if(j > i){
                            result[j][0] = intervals[j + intervalsOverlap][0];
                            result[j][1] = intervals[j + intervalsOverlap][1];
                        }

                    }
                    if(result.length == 1){
                        result[0][0] = intervals[i][0];
                        result[0][1] = intervals[i + intervalsOverlap][1];
                    }
                    return result;
                }

            }
        }

        return result;
    }
}
public class Main {


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {5,6};
        int[][] arrr = {{1,5},{6,8}};

        System.out.println(Arrays.deepToString(s.insert(arrr,arr)));
    }

}