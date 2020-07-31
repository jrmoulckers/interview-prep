import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * LeetCode 3: Longest Substring Without Repeating Characters (MEDIUM)
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 *  Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.              
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Leetcode3LongestSubstringWithoutRepeatingCharacters {
    // Dynamic programming approach: (12.45% spd, 5.10% mem)
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> used = new HashMap<>();
        int max = 0;

        // Hashed keys can look up used characters in constant time
        // HashMap stores indices for reference
        for(int i = 0, j = 0; j < s.length(); j++) {
            if(used.containsKey(s.charAt(j))) {
                i = Math.max(used.get(s.charAt(j)), i);
            }
            max = Math.max(max, j - i + 1);
            used.put(s.charAt(j), j + 1);
        }

        // Edge case: current length may be max, but we have not found repeat
        return max;
    }

    // Brute force approach: check every substring (78.98% spd, 41.24% mem)
    public static int lengthOfLongestSubstringBruteForce(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int max = 0;
        // Hashset can lookup used characters in constant time
        for(int c = 0; c < s.length(); c++) {
            HashSet<Character> used = new HashSet<>();
            int len = 0;
            for(int i = c; i < s.length(); i++) {
                if(!used.contains(s.charAt(i))) {
                    len++;
                    used.add(s.charAt(i));
                } else {
                    break;
                }
            }
            max = Math.max(max, len);
        }
        return max;
    }
    
    public static void main(String[] args) {
        String[] testInputs = {"abcabcbb", "bbbbb", "pwwkew", "abca"};
        int[] testOutputs = {3, 1, 3, 3};

        for(int test = 0; test < testInputs.length; test++) {
            System.out.println();
            System.out.println("Input: " + testInputs[test]);            
            System.out.println("Expected: " + testOutputs[test]);

            int output1 = lengthOfLongestSubstring(testInputs[test]);
            System.out.println("Output: " + output1);
            System.out.println((output1 == testOutputs[test] ? "--- PASS ---" : "--- FAIL ---"));
            int output2 = lengthOfLongestSubstringBruteForce(testInputs[test]);
            System.out.println("Output: " + output2);
            System.out.println((output2 == testOutputs[test] ? "--- PASS ---" : "--- FAIL ---"));
        }
    }
}