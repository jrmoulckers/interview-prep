import java.util.Arrays;

/**
 * Leetcode 88: Merge Sorted Array (EASY)
 * https://leetcode.com/problems/merge-sorted-array/
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * 
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.
 * 
 * Example:
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * Output: [1,2,2,3,5,6]
 * 
 * Constraints:
 * -10^9 <= nums1[i], nums2[i] <= 10^9
 * nums1.length == m + n
 * nums2.length == n
 */
public class Leetcode88MergeSortedArray {
    // Two-pointer comparison approach (100% spd, 28.77% mem)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = nums1.length - 1;
        int p1 = m - 1; 
        int p2 = n - 1;
        while(p2 >= 0) {
            if(p1 < 0 || nums1[p1] <= nums2[p2]) {
                nums1[i] = nums2[p2];
                p2--;
            } else {
                nums1[i] = nums1[p1];
                p1--;
            }
            i--;
        }
    }

    public static void main(String[] args) {
        int[][] testInputs1 = {
            {1, 2, 3, 0, 0, 0},
            {0}
        };
        int[] testInputsM = {3, 0};
        int[][] testInputs2 = {
            {2, 5, 6},
            {1}
        };
        int[] testInputsN = {3, 1};
        int[][] testOutputs = {
            {1, 2, 2, 3, 5, 6},
            {1}
        };

        for(int test = 0; test < testInputs1.length; test++) {
            System.out.println();
            System.out.println("Inputs: \n\t" + Arrays.toString(testInputs1[test]) + "\n\t" + Arrays.toString(testInputs2[test]));            
            System.out.println("Expected: " + Arrays.toString(testOutputs[test]));

            merge(testInputs1[test], testInputsM[test], testInputs2[test], testInputsN[test]);
            int[] output1 = testOutputs[test]; 
            System.out.println("Output: " + Arrays.toString(output1));
            System.out.println((Arrays.equals(output1, testOutputs[test]) ? "--- PASS ---" : "--- FAIL ---"));
        }
    }  
}