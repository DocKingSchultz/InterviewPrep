package ArraysHashing;

//Products of Array Except Self
//Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].
//
//Each product is guaranteed to fit in a 32-bit integer.
//
//Follow-up: Could you solve it in
//O
//        (
//                n
//                )
//O(n) time without using the division operation?

//Input: nums = [1,2,4,6]
//
//Output: [48,24,12,8]


//Input: nums = [-1,0,1,2,3]
//
//Output: [0,-6,0,0,0]


public class ProductsofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prefix = 1;
        int suffix = 1;

        // 1 2 4 6
        // 1 1 2 8

        for(int i=0; i< nums.length;i++)
        {
            res[i] = prefix;
            prefix*=nums[i];
        }
        // 1  2  4  6
        // 48   24  12 8
        for(int i = nums.length-1; i>=0;i--)
        {
            res[i] = suffix*res[i];
            suffix*=nums[i];
        }
        return  res;
    }
}
