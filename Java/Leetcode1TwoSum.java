import java.util.Arrays;
import java.util.HashMap;

/**
 * LeetCode 1: Two Sum
 * https://leetcode.com/problems/two-sum/
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

public class Leetcode1TwoSum {
    // Brute force approach. At each index, check all subsequent indices for match.
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int check = i + 1; check < nums.length; check++) {
                if(nums[i] + nums[check] == target) {
                    return new int[] {i, check};
                }
            }
        }

        throw new IllegalArgumentException("Invalid arguments: must have exactly one solution.");
    }

    // Two pass hash table approach. Add each value to hashmap (constant lookup time).
    // Run through each value again to check if there is a matching value in hashamp.
    public static int[] twoSumTwoPassHashtable(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        // Add each value to hashmap with value as key and index as value
        for(int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        // Run through nums again, checking if the value has a match in the hashmap
        for(int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            // If hashmap contains remaining value, return the indices
            if(numMap.containsKey(remaining) && numMap.get(remaining) != i) {
                return new int[] {i, numMap.get(remaining)};
            }
        }

        throw new IllegalArgumentException("Invalid arguments: must have exactly one solution.");
    }

    // One pass hash table approach. Add each value to hashmap (constant lookup time).
    // While adding, check the current value for a match in the hashmap.
    public static int[] twoSumOnePassHashtable(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        // Perform add and check for each value
        for(int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            // If hashmap contains remaining value, return the indices
            if(numMap.containsKey(remaining)) {
                return new int[] {numMap.get(remaining), i};
            }

            // Add each value to hashmap with value as key and index as value
            numMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("Invalid arguments: must have exactly one solution.");
    }

    public static void main(String[] args) {
        int[] testTargets = {9};
        int[][] testInputs = {
            {2, 7, 11, 15}
        };
        int[][] testOutputs = {
            {0, 1}
        };

        for(int test = 0; test < testTargets.length; test++) {
            System.out.println("Test " + test + ":");
            System.out.println("Input: " + Arrays.toString(testInputs[test]) + "; Target: " + testTargets[test]);            
            System.out.println("Expected: " + Arrays.toString(testOutputs[test]));
            // Brute force          
            int[] output1 = twoSumBruteForce(testInputs[test], testTargets[test]);
            System.out.println("Brute Force Output: " + Arrays.toString(output1));
            System.out.println((Arrays.equals(output1, testOutputs[test]) ? "--- PASS ---" : "--- FAIL ---"));
            // Two pass hash table           
            int[] output2 = twoSumBruteForce(testInputs[test], testTargets[test]);
            System.out.println("Two Pass Output: " + Arrays.toString(output2));
            System.out.println((Arrays.equals(output2, testOutputs[test]) ? "--- PASS ---" : "--- FAIL ---"));
            // One pass hash table           
            int[] output3 = twoSumBruteForce(testInputs[test], testTargets[test]);
            System.out.println("Two Pass Output: " + Arrays.toString(output3));
            System.out.println((Arrays.equals(output3, testOutputs[test]) ? "--- PASS ---" : "--- FAIL ---"));
            System.out.println();
        }
    }
}