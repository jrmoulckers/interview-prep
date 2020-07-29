import java.util.Arrays;
/**
 * Leetcode 14: Longest Common Prefix (EASY)
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 *  Input: ["flower","flow","flight"]
 *  Output: "fl"
 * 
 * Example 2:
 *  Input: ["dog","racecar","car"]
 *  Output: ""
 *  Explanation: There is no common prefix among the input strings.
 * 
 * Note:
 *  All given inputs are in lowercase letters a-z.
 */
public class Leetcode14LongestCommonPrefix {
    // Vertical scanning approach (43.72% spd, 12.53% mem)
    public static String longestCommonPrefix(String[] strs) {
        // Edge cases: empty input or single value input
        if(strs == null || strs.length == 0) {
            return "";
        } else if(strs.length == 1) {
            return strs[0];
        }

        // Check for each value in first string
        for(int c = 0; c < strs[0].length(); c++) {
            char current = strs[0].charAt(c);
            // Compare each string to first string at current index
            for(int s = 1; s < strs.length; s++) {
                // Return existing prefix if string cannot fit or has different character
                if(strs[s].length() <= c || strs[s].charAt(c) != current) {
                    return strs[0].substring(0, c);
                }
            }
        }
        return strs[0];
    }

    // Sorting approach (FASTEST), sort of a cop out (70.03% spd, 74.35% mem)
    public static String longestCommonPrefixSorted(String[] strs) {
        // Edge cases: empty input or single value input
        if(strs == null || strs.length == 0) {
            return "";
        } else if(strs.length == 1 ) {
            return strs[0];
        }

        // Perform fast sort, take first and last strings to compare
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];

        int c = 0;

        // Check each index for both strings
        while(c < s1.length()) {
            if(s1.charAt(c) == s2.charAt(c)) {
                c++;
            } else {
                break;
            }
        }

        return c == 0 ? "" : s1.substring(0, c);
    }

    public static void main(String[] args) {
        String[][] testInputs = {
            {"flower", "flow", "flight"},
            {"dog", "racecar", "car"},
            {}
        };
        String[] testOutputs = {"fl", "", ""};

        for(int test = 0; test < testInputs.length; test++) {
            System.out.println();
            System.out.println("Input: " + Arrays.toString(testInputs[test]));            
            System.out.println("Expected: \"" + testOutputs[test] + "\"");

            String output1 = longestCommonPrefix(testInputs[test]);
            System.out.println("Vertical Scanning Approach Output: \"" + output1 + "\"");
            System.out.println((output1.equals(testOutputs[test]) ? "--- PASS ---" : "--- FAIL ---"));
            String output2 = longestCommonPrefixSorted(testInputs[test]);
            System.out.println("Sorted Approach Output: \"" + output2 + "\"");
            System.out.println((output2.equals(testOutputs[test]) ? "--- PASS ---" : "--- FAIL ---"));
        }
    }
}