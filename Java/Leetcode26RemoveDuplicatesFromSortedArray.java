import java.util.Arrays;

/**
 * Leetcode 26: Remove Duplicates from Sorted Array (EASY)
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length. Do not allocate extra
 * space for another array, you must do this by modifying the input array
 * in-place with O(1) extra memory.
 * 
 * Example 1: Given nums = [1,1,2], Your function should return length = 2, with
 * the first two elements of nums being 1 and 2 respectively. It doesn't matter
 * what you leave beyond the returned length.
 * 
 * Example 2: Given nums = [0,0,1,1,1,2,2,3,3,4], Your function should return
 * length = 5, with the first five elements of nums being modified to 0, 1, 2,
 * 3, and 4 respectively. It doesn't matter what values are set beyond the
 * returned length.
 * 
 * Clarification: Confused why the returned value is an integer but your answer
 * is an array? Note that the input array is passed in by reference, which means
 * modification to the input array will be known to the caller as well.
 * 
 * Internally you can think of this: // nums is passed in by reference. (i.e.,
 * without making a copy) int len = removeDuplicates(nums);
 * 
 * // any modification to nums in your function would be known by the caller. //
 * using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) { print(nums[i]); }
 */
public class Leetcode26RemoveDuplicatesFromSortedArray {

    // Linear one pass approach (100% spd, 17.44% mem)
    public static int removeDuplicates(int[] nums) {
        // Edge case:  return 0 for empty array
        if(nums.length == 0) {
            return 0;
        }
        int retPointer = 1;
        int lastVal = nums[0];
        for(int i = 1; i < nums.length; i++) {
            // Add val to resulting array if no duplicate
            if(nums[i] != lastVal) {
                nums[retPointer] = nums[i];
                retPointer++;
            }
            lastVal = nums[i];
        }
        return retPointer;
    }

    public static void main(String[] args) {
        int[][] testInputs = {
            {1, 1, 2},
            {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
        };
        int[][] testArrayOutputs = {
            {1, 2},
            {0, 1, 2, 3, 4}
        };
        int[] testIntOutputs = {2, 5};

        for(int test = 0; test < testInputs.length; test++) {
            System.out.println();
            System.out.println("Input: " + Arrays.toString(testInputs[test]));            
            System.out.println("Expected: " + testIntOutputs[test] + " length, " + Arrays.toString(testArrayOutputs[test]));

            int outputInt = removeDuplicates(testInputs[test]);
            int[] outputArray = testInputs[test]; 
            System.out.println("Output: " + outputInt + " length, " + Arrays.toString(outputArray));
            System.out.println((isEquivalent(outputArray, testArrayOutputs[test], testArrayOutputs[test].length) && outputInt == testIntOutputs[test]) ? "--- PASS ---" : "--- FAIL ---");
        }
    }  

    // Checks equivalency of arrays up to expected index
    public static boolean isEquivalent(int[] outputArray, int[] correctArray, int numIndices) {
        for(int i = 0; i < numIndices; i++) {
            if(outputArray[i] != correctArray[i]) {
                return false;
            }
        }
        return true;
    }
}