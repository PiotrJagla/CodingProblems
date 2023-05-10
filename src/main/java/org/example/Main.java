package org.example;



class Solution {
    public int maxChunksToSorted(int[] arr) {
        int result = 1;
        int currentChunkStart = 0;
        int currentChunkEnd = 1;

        int minElement = arr[arr.length-1];
        boolean isSorted = true;
        for(int i = 0 ; i < arr.length -1; ++i){
            if(arr[i] < minElement){
                minElement = arr[i];
            }

            if(arr[i] > arr[i+1])
                isSorted = false;
        }

        if(isSorted)
            return arr.length;

        for(int i = 0 ; i < arr.length - 1 ; ++i){
            if(arr[i] > arr[i+1]){
                currentChunkEnd++;
            }
            int currentChunkMax = max(arr, currentChunkStart, currentChunkEnd);
            int restOfArrMin = min(arr,i + 1, arr.length);

            if(restOfArrMin >= arr[i+1] && currentChunkMax <= arr[i+1]){
                result++;
                currentChunkStart = i;
                currentChunkEnd = i + 1;
            }
            else if(currentChunkMax == arr[i+1] && currentChunkMax == minElement){
                result++;
                currentChunkStart = i;
                currentChunkEnd = i + 1;
            }
            else if(currentChunkMax == arr[i+1] && currentChunkMax != minElement){
                ++currentChunkEnd;
            }
            else if(currentChunkMax < arr[i+1] && i != 0){
                result++;
                currentChunkStart = i;
                currentChunkEnd = i + 1;
            }
            else if(currentChunkMax > restOfArrMin){
                ++currentChunkEnd;
            }

        }
        return result;
    }


    private int max(int[] arr, int start, int end) {
        int result = 0;
        for (int i = start ; i < end && i < arr.length ; ++i){
            if(arr[i] > result){
                result = arr[i];
            }
        }
        return result;
    }

    private int min(int[] arr, int start, int end) {
        int result = arr[start];
        for (int i = start ; i < end ; ++i){
            if(arr[i] < result){
                result = arr[i];
            }
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