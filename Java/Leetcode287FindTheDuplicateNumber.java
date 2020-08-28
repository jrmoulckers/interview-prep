import java.util.Arrays;

/**
 * Leetcode 287: Find the Duplicate Number (MEDIUM)
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Example 1: Input: [1,3,4,2,2] Output: 2 Example 2: Input: [3,1,3,4,2] Output:
 * 3
 * 
 * Note: You must not modify the array (assume the array is read only). You must
 * use only constant, O(1) extra space. Your runtime complexity should be less
 * than O(n2). There is only one duplicate number in the array, but it could be
 * repeated more than once.
 */
public class Leetcode287FindTheDuplicateNumber {

    // Swap values to correct location approach (% spd, % mem)
    public static int findDuplicate(int[] nums) {
        // Swap value to the correct location. If already a match, return???
        return -1;
    }

    public static void main(final String[] args) {
        final int[][] testInputs = {
            {1, 3, 4, 2, 2},
            {3, 1, 3, 4, 2}
        };

        final int[] testOutputs = {2, 3};

        for(int test = 0; test < testInputs.length; test++) {
            System.out.println();
            System.out.println("Input: " + Arrays.toString(testInputs[test]));            
            System.out.println("Expected: " + testOutputs[test]);

            final int output1 = findDuplicate(testInputs[test]);
            System.out.println("Output: " + output1);
            System.out.println(output1 == testOutputs[test] ? "--- PASS ---" : "--- FAIL ---");
        }
    } 
}