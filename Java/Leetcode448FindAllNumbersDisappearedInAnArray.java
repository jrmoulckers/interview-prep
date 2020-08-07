import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 448: Find All Duplicates in an Array (MEDIUM)
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * 
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
 * elements appear twice and others appear once. Find all the elements of [1, n]
 * inclusive that do not appear in this array.
 * 
 * Could you do it without extra space and in O(n) runtime? You may assume the
 * returned list does not count as extra space.
 * 
 * Example: 
 *  Input: [4,3,2,7,8,2,3,1] 
 *  Output: [5,6]
 */
public class Leetcode448FindAllNumbersDisappearedInAnArray {

    // Simple linear pass solution (93.88% spd, 9.09% mem)
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> disappeared = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int j = Math.abs(nums[i]);
            if(nums[j - 1] > 0) {
                nums[j - 1] *= -1;
            }
        }
        for(int i = 1; i <= nums.length; i++) {
            if(nums[i - 1] > 0) {
                disappeared.add(i);
            }
        }

        return disappeared;
    }
    
    public static void main(String[] args) {
        int[][] testInputs = {
            {4, 3, 2, 7, 8, 2, 3, 1}
        };

        int[][] testOutputs = {
            {5, 6}
        };

        for(int test = 0; test < testInputs.length; test++) {
            System.out.println();
            System.out.println("Input: " + Arrays.toString(testInputs[test]));            
            System.out.println("Expected: " + Arrays.toString(testOutputs[test]));

            List<Integer> output1 = findDisappearedNumbers(testInputs[test]);
            System.out.println("Output: " + output1.toString());
            System.out.println(isEquivalent(output1, testOutputs[test]) ? "--- PASS ---" : "--- FAIL ---");
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