package org.example;



class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] leftMax = new int[arr.length];
        int[] rightMin = new int[arr.length];

        leftMax[0] = arr[0];
        for(int i = 1 ; i < arr.length ; ++i){
            leftMax[i] = Math.max(arr[i], leftMax[i-1]);
        }

        rightMin[arr.length - 1] = arr[arr.length - 1];
        for(int i = arr.length - 2 ; i >= 0 ; --i){
            rightMin[i] = Math.min(arr[i], rightMin[i+1]);
        }

        int result = 1;
        for(int i = 0 ; i < arr.length - 1 ; ++i){
            if(leftMax[i] <= rightMin[i+1])
                result++;
        }

        return result;
    }

}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {0,3,0,3,2};
        System.out.println(s.maxChunksToSorted(arr));


    }
}