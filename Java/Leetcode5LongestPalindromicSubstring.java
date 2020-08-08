/**
 * Leetcode 5: Longest Palindromic Substring (MEDIUM)
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * Given a string s, find the longest palindromic substring in s. 
 * You may assume that the maximum length of s is 1000.
 * 
 * Example 1:
 *  Input: "babad"
 *  Output: "bab"
 *  Note: "aba" is also a valid answer.
 * 
 * Example 2:
 *  Input: "cbbd"
 *  Output: "bb"
 */
public class Leetcode5LongestPalindromicSubstring {
    
    // Double loop approach (98.30% spd, 65.26% mem)
    public static String longestPalindrome(String s) {
        int max = 0;
        String maxPalindrome = "";
        char[] sArr = s.toCharArray();

        for(int i = 0; i < sArr.length; i++) {
            int len = 0;  // Current length of palindrome
            int c = i; // Current character
            // Check equivalent vals around i, center palindrome
            while(c < sArr.length && sArr[c] == sArr[i]) {
                c++;
                len++;
            }

            int bLo = i - 1;  // Lower border index
            int bHi = c;  // Upper border index
            while(bLo >= 0 && bHi < sArr.length) {
                // Check that surrounding vals equivalent
                if(sArr[bLo] == sArr[bHi]) {
                    len += 2;
                    bLo--;
                    bHi++;
                } else {
                    break;
                }
            }

            if(len > max) {
                maxPalindrome = new String(sArr, bLo + 1, len);
                max = len;
            }
        }

        return maxPalindrome;
    }
}