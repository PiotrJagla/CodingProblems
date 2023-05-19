package org.example;

import javax.swing.plaf.InsetsUIResource;
import java.util.*;


class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int start = 0;
        int end = 1;
        int height = 2;
        List<List<Integer>> skyline = new ArrayList<>();

        int[][] points = new int[buildings.length * 2][3];

        for (int i = 0; i < buildings.length; i++) {
            points[i * 2][0] = buildings[i][start];
            points[i * 2][1] = buildings[i][height];
            points[i * 2][2] = start;

            points[i*2 + 1][0] = buildings[i][end];
            points[i*2 + 1][1] = buildings[i][height];
            points[i*2 + 1][2] = end;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return Integer.compare(o1[0], o2[0]);
                }else{
                    return (o1[2] == start ? -o1[1] : o1[1]) - (o2[2] == start ? -o2[1] : o2[1]);
                }

            }
        });

        PriorityQueue<Integer> pointsQueue = new PriorityQueue<>((a,b) -> b - a);
        pointsQueue.offer(0);
        int currentMax = 0;
        for (int i = 0; i < points.length; i++) {
            if(points[i][2] == start){
                pointsQueue.offer(points[i][1]);
                if(currentMax != pointsQueue.peek()){
                    skyline.add(new ArrayList<>());
                    skyline.get(skyline.size() - 1).add(points[i][0]);
                    skyline.get(skyline.size() - 1).add(pointsQueue.peek());
                    currentMax = pointsQueue.peek();
                }
            }
            else if(points[i][2] == end){
                pointsQueue.remove(points[i][1]);
                if(currentMax != pointsQueue.peek()){
                    skyline.add(new ArrayList<>());
                    skyline.get(skyline.size() - 1).add(points[i][0]);
                    skyline.get(skyline.size() - 1).add(pointsQueue.peek());
                    currentMax = pointsQueue.peek();
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