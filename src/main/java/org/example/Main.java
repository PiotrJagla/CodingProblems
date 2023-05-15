package org.example;




//class Solution {
//    public int solution(int N) {
//        for(int i = N + 1 ; ; ++i){
//            if(sumAllDigitsOf(i) == 2* sumAllDigitsOf(N)){
//                return i;
//            }
//        }
//    }
//    private int sumAllDigitsOf(int aNumber){
//        int result = 0;
//        for (int i = aNumber; i != 0 ; i /= 10) {
//            result += i%10;
//        }
//        return result;
//    }
//}
//
//
//
//
//class Solutionm {
//    public int solution(int[] A) {
//        int tailsCount = 0;
//        int headsCount = 0;
//        for (int i = 0; i < A.length; i++) {
//            if(A[i] == 0){
//                ++headsCount;
//            }
//            else if(A[i] == 1){
//                ++tailsCount;
//            }
//        }
//
//        int half = A.length/2;
//        int maxCount = Math.max(tailsCount, headsCount);
//        int distanceToHalf = Math.abs( maxCount - half );
//        return distanceToHalf;
//    }
//}
//
//
//class Solutionmm {
//    public int solution(int[] A) {
//        int sum = 0;
//        int summedIntegersCount = 0;
//        for (int i = 0; i < A.length; i++) {
//            if(A[i] > 0 && summedIntegersCount < 3){
//                sum += A[i];
//                summedIntegersCount++;
//            }
//        }
//        return sum;
//    }
//}

import java.util.Scanner;

class Point2D{
    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class Main {

    public static boolean canBeTriangle(Point2D A,Point2D B,Point2D C){
        double sideAB = Math.sqrt( (B.getX() - A.getX())*(B.getX() - A.getX()) + (B.getY() - A.getY())*(B.getY() - A.getY()) );
        double sideBC = Math.sqrt( (C.getX() - B.getX())*(C.getX() - B.getX()) + (C.getY() - B.getY())*(C.getY() - B.getY()) );
        double sideAC = Math.sqrt( (A.getX() - C.getX())*(A.getX() - C.getX()) + (A.getY() - C.getY())*(A.getY() - C.getY()) );

        if(sideAB < sideBC + sideAC){
            return true;
        }
        else if(sideBC < sideAB + sideAC){
            return true;
        }
        else if(sideAC < sideAB + sideBC){
            return true;
        }

        return false;
    }

    private static int getIntInput(String title) {
        Scanner in = new Scanner(System.in);
        System.out.println(title);
        int result = -1;
        for (int i = 0; i < 3; ++i) {
            try {
                result = Integer.parseInt(in.next());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Wprowadzono zla wartosc");
            }

        }
        if(result == -1){
            System.exit(1);
        }
        return result;
    }



    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Point2D A = new Point2D(0,0);
        Point2D B = new Point2D(0,0);
        Point2D C = new Point2D(0,0);

        A.setX(getIntInput("get A x: "));
        A.setY(getIntInput("get A y: "));

        B.setX(getIntInput("get B x: "));
        B.setY(getIntInput("get B y: "));

        C.setX(getIntInput("get C x: "));
        C.setY(getIntInput("get C y: "));


        System.out.println(canBeTriangle(A,B,C));

    }
}