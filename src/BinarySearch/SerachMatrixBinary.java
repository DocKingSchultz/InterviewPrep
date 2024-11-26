package BinarySearch;

//You are given an m x n 2-D integer array matrix and an integer target.
//
//Each row in matrix is sorted in non-decreasing order.
//The first integer of every row is greater than the last integer of the previous row.
//Return true if target exists within matrix or false otherwise.
//
//Can you write a solution that runs in O(log(m * n)) time?

import java.util.ArrayList;
import java.util.Arrays;

public class SerachMatrixBinary {
//    public boolean searchMatrixWorseSolution(int[][] matrix, int target) {
//        // Find the range, or the row where the number should exist :
//        for (int[] ints : matrix) {
//            if (target > ints[0] && target < ints[ints.length - 1])
//                BinarySearchAlg.findBinary(0, ints.length - 1, ints, target);
//        }
//    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        return  findBinaryMatrix(0, matrix.length*matrix[0].length-1, target, matrix);
    }
    public static boolean findBinaryMatrix(int left, int right, int target, int[][]matrix)
    {
        if(left>right)return false;
        int mid = left+ (right-left)/2;
        int numCol = matrix[0].length;
        int row = mid/numCol;
        int col = mid%numCol;
        int currentNumber = matrix[row][col]; // made mistake with the calculation
        if(currentNumber==target)return true;
        return target>currentNumber?findBinaryMatrix(mid+1,right, target, matrix):findBinaryMatrix(left,mid-1, target, matrix);
    }
}
