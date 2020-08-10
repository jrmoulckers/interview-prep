import java.util.Arrays;
import java.util.HashSet;

import HelperClasses.ArrayHelper;

/**
 * Leetcode 268: Missing Number (EASY)
 * https://leetcode.com/problems/missing-number/
 * 
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 * find the one that is missing from the array.
 * 
 * Example 1:
 *  Input: [3,0,1]
 *  Output: 2
 * Example 2:
 *  Input: [9,6,4,2,3,5,7,0,1]
 *  Output: 8
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. 
 * Could you implement it using only constant extra space complexity?
 */
public class Leetcode268MissingNumber {
    
    // Simple two-pass approach O(N) time, O(1) space (60.12% spd, 72.08% mem)
    public static int missingNumber(final int[] nums) {
        int i = 0;
        while(i < nums.length) {
            // Swap all vals to their index - 1 (not zero)
            if(nums[i] != 0 && nums[i] != nums[nums[i] - 1]) {
                ArrayHelper.swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        i = 0;
        // Now find 0, which gives the index of the missing number
        while(i < nums.length && nums[i] != 0) {
            i++;
        }

        return i == nums.length ? 0 : i + 1;
    }

    // Easy HashSet approach O(N) time & space (25.06% spd, 97.46% mem)
    public static int missingNumberHashSet(int[] nums){
        HashSet<Integer> allNums = new HashSet<>();
        // Add all values to HashSet for constant lookup time
        for(int n : nums) {
            allNums.add(n);
        }

        // Return value not found in HashSet
        for(int i = 0; i <= nums.length; i++) {
            if(!allNums.contains(i)) {
                return i;
            }
        }

        throw new IllegalArgumentException();
    }
    
    public static void main(final String[] args) {
        final int[][] testInputs = {
            {3, 0, 1},
            {9, 6, 4, 2, 3, 5, 7, 0, 1},
            {3, 1, 2, 5, 4}
        };

        final int[] testOutputs = {2, 8, 0};

        for(int test = 0; test < testInputs.length; test++) {
            System.out.println();
            System.out.println("Input: " + Arrays.toString(testInputs[test]));            
            System.out.println("Expected: " + testOutputs[test]);

            final int output1 = missingNumber(testInputs[test]);
            System.out.println("Output: " + output1);
            System.out.println(output1 == testOutputs[test] ? "--- PASS ---" : "--- FAIL ---");
            final int output2 = missingNumberHashSet(testInputs[test]);
            System.out.println("Output: " + output2);
            System.out.println(output2 == testOutputs[test] ? "--- PASS ---" : "--- FAIL ---");
        }
    } 
}