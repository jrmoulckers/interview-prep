import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Leetcode 442: Find All Duplicates in an Array (MEDIUM)
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * 
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements
 * appear twice and others appear once. Find all the elements that appear twice
 * in this array.
 * 
 * Could you do it without extra space and in O(n) runtime?
 * 
 * Example: Input: [4,3,2,7,8,2,3,1]
 * 
 * Output: [2,3]
 */
public class Leetcode442FindAllDuplicatesInAnArray {
    
    // Optimal no-space solution, O(N) time, constant space (96.69%% spd, 9.59% mem)
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        // Run through each value
        for(int i = 0; i < nums.length; i++) {
            int j = Math.abs(nums[i]);
            if(nums[j - 1] < 0) {
                duplicates.add(j);
            } else {
                nums[j - 1] *= -1;
            }
        }
        return duplicates;
    }
    
    // Simple HashSet solution, O(N) time & space (22.75% spd, 70.78% mem)
    public static List<Integer> findDuplicatesExtraSpace(int[] nums) {
        HashSet<Integer> found = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(found.contains(nums[i])) {
                duplicates.add(nums[i]);
            } else {
                found.add(nums[i]);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        int[][] testInputs = {
            {4, 3, 2, 7, 8, 2, 3, 1}
        };

        int[][] testOutputs = {
            {2, 3}
        };

        for(int test = 0; test < testInputs.length; test++) {
            System.out.println();
            System.out.println("Input: " + Arrays.toString(testInputs[test]));            
            System.out.println("Expected: " + Arrays.toString(testOutputs[test]));

            List<Integer> output1 = findDuplicates(testInputs[test]);
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