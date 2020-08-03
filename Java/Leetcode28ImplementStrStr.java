/**
 * Leetcode 28: Implement strStr() (EASY)
 * https://leetcode.com/problems/implement-strstr/
 * 
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * 
 * Example 1:
 *  Input: haystack = "hello", needle = "ll"
 *  Output: 2
 * 
 * Example 2:
 *  Input: haystack = "aaaaa", needle = "bba"
 *  Output: -1
 * 
 * Clarification:
 *  What should we return when needle is an empty string? This is a great question to ask during an interview.
 *  For the purpose of this problem, we will return 0 when needle is an empty string. 
 *  This is consistent to C's strstr() and Java's indexOf().
 * 
 *  
 */
public class Leetcode28ImplementStrStr {

    // Quadratic approach (100% spd, 5.17% mem)
    public static int strStr(String haystack, String needle) {  
        int i = 0;
        int j = 0;
        
        if (needle.length() == 0) {
            return 0;
        }
        
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
            i++;
            if (j == needle.length()) {
                return i - j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] testHaystackInputs = {"hello", "aaaaa"};
        String[] testNeedleInputs = {"ll", "bba"};
        int[] testOutputs = {2, -1};

        for(int test = 0; test < testHaystackInputs.length; test++) {
            System.out.println();
            System.out.println("Input: Haystack = " + testHaystackInputs[test] + ", Needle = "  + testNeedleInputs[test]);            
            System.out.println("Expected: " + testOutputs[test]);

            int output = strStr(testHaystackInputs[test], testNeedleInputs[test]);
            System.out.println("Output: " + output);
            System.out.println(output == testOutputs[test] ? "--- PASS ---" : "--- FAIL ---");
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