package org.example;

import javax.swing.plaf.InsetsUIResource;
import java.util.*;


class Solution {
    public boolean canJump(int[] nums) {

        Queue<Integer> vertexesQueue = new LinkedList<>();
        vertexesQueue.add(0);
        boolean[] isVisited = new boolean[nums.length];
        Arrays.fill(isVisited, false);

        while(vertexesQueue.isEmpty() == false){
            int currentVertex = vertexesQueue.peek();
            vertexesQueue.remove();
            for (int adjacent = currentVertex; adjacent < nums.length && adjacent <= currentVertex + nums[currentVertex]; adjacent++) {
                if(isVisited[adjacent] == false){
                    isVisited[adjacent] = true;
                    vertexesQueue.add(adjacent);
                }
            }
        }

        return isVisited[nums.length-1];
    }
}



public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] arr = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int[] arrr = {1,1,2,2,0,1,1};
        System.out.println(s.canJump(arrr));
    }
}