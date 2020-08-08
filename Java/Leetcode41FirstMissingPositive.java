import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 41: First Missing Positive (HARD)
 * https://leetcode.com/problems/first-mising-positive/
 * 
 * Given an unsorted integer array, find the smallest missing positive integer.
 * 
 * Example 1:
 *  Input: [1,2,0]
 *  Output: 3
 * 
 * Example 2:
 *  Input: [3,4,-1,1]
 *  Output: 2
 * 
 * Example 3:
 *  Input: [7,8,9,11,12]
 *  Output: 1
 */
public class Leetcode41FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        return -1;
    }
    
    public static void main(String[] args) {
        int[][] testInputs = {
            {1, 2, 0},
            {3, 4, -1, 1},
            {7, 8, 9, 11, 12}
        };

        int[] testOutputs = {3, 2, 1};

        for(int test = 0; test < testInputs.length; test++) {
            System.out.println();
            System.out.println("Input: " + Arrays.toString(testInputs[test]));            
            System.out.println("Expected: " + testOutputs[test]);

            int output1 = firstMissingPositive(testInputs[test]);
            System.out.println("Output: " + output1);
            System.out.println(output1 == testOutputs[test] ? "--- PASS ---" : "--- FAIL ---");
        }
    } 

    // Compares both int arrays
    public static boolean isEquivalent(List<Integer> a, int[] b) {
        if (a.size() != b.length) {
            return false;
        }

        for(int i = 0; i < a.size(); i++) {
            if(!(a.get(i) == b[i])) {
                return false;
            }
        }

        return true;
    }
}