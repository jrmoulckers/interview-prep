import java.util.Arrays;

/**
 * Leetcode 35: Search Insert Position (EASY)
 * https://leetcode.com/problems/search-insert-position/
 * 
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * IMPORTANT: You may assume no duplicates in the array.
 * 
 * Example 1: Input: [1,3,5,6], 5 Output: 2
 * 
 * Example 2: Input: [1,3,5,6], 2 Output: 1
 * 
 * Example 3: Input: [1,3,5,6], 7 Output: 4
 * 
 * Example 4: Input: [1,3,5,6], 0 Output: 0
 */
public class Leetcode35SearchInsertPosition {
    // Binary search approach (100% spd, 14.23% mem)
    public static int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public static int binarySearch(int[] arr, int target, int lo, int hi) {
        if(lo == hi) {
            return target <= arr[lo] ? lo : lo + 1;
        } 
        int mid = (lo + hi) / 2;
        if(target > arr[mid]) {
            return binarySearch(arr, target, mid + 1, hi);
        } else {
            return binarySearch(arr, target, lo, mid);
        }
    }

    public static void main(String[] args) {
        int[][] testArrayInputs = {
            {1, 3, 5, 6},
            {1, 3, 5, 6},
            {1, 3, 5, 6},
            {1, 3, 5, 6}
        };
        int[] testIntInputs = {5, 2, 7, 0};
        int[] testOutputs = {2, 1, 4, 0};

        for(int test = 0; test < testIntInputs.length; test++) {
            System.out.println();
            System.out.println("Input: Val = " + testIntInputs[test] + ", "  + Arrays.toString(testArrayInputs[test]));            
            System.out.println("Expected: " + testOutputs[test]);

            int outputInt = searchInsert(testArrayInputs[test], testIntInputs[test]);
            System.out.println("Output: " + outputInt);
            System.out.println(outputInt == testOutputs[test] ? "--- PASS ---" : "--- FAIL ---");
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