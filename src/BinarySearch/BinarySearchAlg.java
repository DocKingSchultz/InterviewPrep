package BinarySearch;

//Binary Search
//You are given an array of distinct integers nums, sorted in ascending order, and an integer target.
//
//Implement a function to search for target within nums. If it exists, then return its index, otherwise, return -1.
//
//Your solution must run in
//O
//        (
//                l
//                        o
//g
//                        n
//        )
//O(logn) time.

import java.util.Arrays;

public class BinarySearchAlg {

    public int search(int[] nums, int target) {
        // Arrays.binarySearch(nums, target);
        return findBinary(0, nums.length-1, nums, target);
    }
    public static int findBinary(int left, int right, int[] nums, int target)
    {
        if(left>right)return -1;
        // Find new mid
        int mid = left + (right-left)/2;
        if(nums[mid]==target)return mid;
        return target>nums[mid]?findBinary(mid+1, right, nums, target):findBinary(left, mid-1, nums, target);
    }

}
