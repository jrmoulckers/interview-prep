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

    // Two-pass swap approach (100% spd, 68.60% mem)
    public static int firstMissingPositive(int[] nums) {
        int i = 0;

        // Swap values to their (hopefully) corresp. places in the array
        while(i < nums.length) {
            // Swap all values that are in the range that can be placed properly in their index
            // Re-run over this area to check the newly swapped value's correct location
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }

        // Re-run over all, returning the running lowest integer if gap is found
        for(i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }        
        }  

        // There may only be N integers. If all 1 through N match, return N + 1
        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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