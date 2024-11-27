package ArraysHashing;

//Two Sum
//Solved
//Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.
//
//You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
//
//Return the answer with the smaller index first.

//Input:
//nums = [3,4,5,6], target = 7
//
//Output: [0,1]

//Input: nums = [4,5,6], target = 10
//
//Output: [0,2]


import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++)
        {
            if(map.containsKey(target - nums[i]))
            {
                int index1 = map.get(target - nums[i]);
                int index2 = i;
                return index1 < index2 ? new int[]{index1, index2} : new int[]{index2, index1};
            }
            else
            {
                map.put(nums[i], i);
            }
        }
        return new int[2];
    }
}
