import java.util.Arrays;

/**
 * Leetcode 26: Remove Duplicates from Sorted Array (EASY)
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *  
 * Given an array nums and a value val, remove all instances of that value in-place 
 * and return the new length. Do not allocate extra space for another array, 
 * you must do this by modifying the input array in-place with O(1) extra memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * Example 1:
 *  Given nums = [3,2,2,3], val = 3,
 *  Your function should return length = 2, with the first two elements of nums being 2.
 *  It doesn't matter what you leave beyond the returned length.
 * 
 * Example 2:
 *  Given nums = [0,1,2,2,3,0,4,2], val = 2,
 *  Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 *  Note that the order of those five elements can be arbitrary.
 *  It doesn't matter what values are set beyond the returned length.
 * 
 * Clarification:
 *  Confused why the returned value is an integer but your answer is an array?
 *  Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 *  Internally you can think of this:
 *      // nums is passed in by reference. (i.e., without making a copy)
 *      int len = removeElement(nums, val);
 *      // any modification to nums in your function would be known by the caller.
 *      // using the length returned by your function, it prints the first len elements.
 *      for (int i = 0; i < len; i++) {
 *          print(nums[i]);
 *      }
 */
public class Leetcode27RemoveElement {

    // Linear one pass approach (100% spd, 5.17% mem)
    public static int removeElement(int[] nums, int val) {
        // Edge case:  return 0 for empty array
        if(nums.length == 0) {
            return 0;
        }
        int retPointer = 0;
        for(int i = 0; i < nums.length; i++) {
            // Add val to resulting array if not a match
            if(nums[i] != val) {
                nums[retPointer] = nums[i];
                retPointer++;
            }
        }
        return retPointer;
    }

    public static void main(String[] args) {
        int[][] testArrayInputs = {
            {3, 2, 2, 3},
            {0, 1, 2, 2, 3, 0, 4, 2}
        };
        int[] testIntInputs = {3, 2};
        int[][] testArrayOutputs = {
            {2, 2},
            {0, 1, 3, 0, 4}
        };
        int[] testIntOutputs = {2, 5};

        for(int test = 0; test < testIntInputs.length; test++) {
            System.out.println();
            System.out.println("Input: Val = " + testIntInputs[test] + ", "  + Arrays.toString(testArrayInputs[test]));            
            System.out.println("Expected: " + testIntOutputs[test] + " length, " + Arrays.toString(testArrayOutputs[test]));

            int outputInt = removeElement(testArrayInputs[test], testIntInputs[test]);
            int[] outputArray = testArrayInputs[test]; 
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