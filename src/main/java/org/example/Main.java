package org.example;


import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(isCellValid(board, j, i) == false){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isCellValid(char[][] board, int cellPosX, int cellPosY) {

        if(board[cellPosY][cellPosX] == '.')
            return true;

        int boxLeft = cellPosX / 3;
        int boxUp = cellPosY / 3;
        boxLeft *= 3;
        boxUp *= 3;
        for (int y = boxUp ; y < boxUp + 3; ++y) {
            for (int x = boxLeft; x < boxLeft + 3; x++) {

                if (cellPosX != x && cellPosY != y) {
                    if (board[y][x] == board[cellPosY][cellPosX]) {
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i != cellPosX) {
                if (board[cellPosY][i] == board[cellPosY][cellPosX]) {
                    return false;
                }
            }

        }

        for (int i = 0; i < 9; i++) {
            if (i != cellPosY) {
                if (board[i][cellPosX] == board[cellPosY][cellPosX]) {
                    return false;
                }
            }

        }


        return true;
    }
}


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {27,5,24,17,27,4,23,16,6,26,13,17,21,3,9,10,28,26,4,10,28,2};
        int[] arr2 = {26,9,14,17,6,14,23,24,11,6,27,14,13,1,15,5,12,15,23,27,28,12};
        //System.out.println(s.earliestFullBloom(arr, arr2));


    }
}