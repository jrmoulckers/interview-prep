/**
 * Leetcode 278: Maximum Subarray (EASY)
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number) 
 * which has the largest sum and return its sum.
 * 
 * Example:
 *  Input: [-2,1,-3,4,-1,2,1,-5,4],
 *  Output: 6
 *  Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 * Follow up:
 *  If you have figured out the O(n) solution, 
 *  try coding another solution using the divide and conquer approach, 
 *  which is more subtle.
 */
public class Leetcode53MaximumSubarray {

    // Linear running total approach Kadane's Alg. (78.24% spd, 5.19% mem)
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum > max) {
                max = sum;
            }
            if(sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}