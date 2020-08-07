import java.util.Arrays;

/**
 * Leetcode 66: Plus One (EASY)
 * https://leetcode.com/problems/plus-one/
 * 
 * Given a non-empty array of digits representing a non-negative integer,
 * increment one to the integer. The digits are stored such that the most
 * significant digit is at the head of the list, and each element in the array
 * contains a single digit. You may assume the integer does not contain any
 * leading zero, except the number 0 itself.
 * 
 * Example 1: Input: [1,2,3] Output: [1,2,4] Explanation: The array represents
 * the integer 123.
 * 
 * Example 2: Input: [4,3,2,1] Output: [4,3,2,2] Explanation: The array
 * represents the integer 4321.
 */
public class Leetcode66PlusOne {
    
    // Simple reverse linear approach (100% spd, 13.47% mem)
    public static int[] plusOne(int[] digits) {
        int length = digits.length - 1;
        // Run through each digit and add one where necessary
        for(int i = length; i >= 0; i--) {
            // Case: digit below 9, just add one
            if(digits[i] != 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
            // Edge case: plus one puts val over to new decimal
            if(i == 0) {
                digits = new int[length + 2];
                digits[i] = 1;
            }
        }
        return digits;
    }
        
    public static void main(String[] args) {
        int[][] testInputs = {
            {1, 2, 3},
            {4, 3, 2, 1}
        };

        int[][] testOutputs = {
            {1, 2, 4},
            {4, 3, 2, 2}
        };

        for(int test = 0; test < testInputs.length; test++) {
            System.out.println();
            System.out.println("Input: " + Arrays.toString(testInputs[test]));            
            System.out.println("Expected: " + Arrays.toString(testOutputs[test]));
            int[] output = plusOne(testInputs[test]);
            System.out.println("Output: " + Arrays.toString(output));
            System.out.println(Arrays.equals(output, testOutputs[test]) ? "--- PASS ---" : "--- FAIL ---");
        }
    } 
}