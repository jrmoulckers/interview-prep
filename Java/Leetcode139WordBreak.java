import java.util.HashSet;
import java.util.List;

/**
 * Leetcode 139: Word Break (MEDIUM)
 * https://leetcode.com/problems/word-break/
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Note:
 *     The same word in the dictionary may be reused multiple times in the segmentation.
 *     You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *     Input: s = "leetcode", wordDict = ["leet", "code"]
 *     Output: true
 *     Explanation: Return true because "leetcode" can be segmented as "leet code".
 * 
 * Example 2:
 *     Input: s = "applepenapple", wordDict = ["apple", "pen"]
 *     Output: true
 *     Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *         Note that you are allowed to reuse a dictionary word.
 * 
 * Example 3:
 *     Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 *     Output: false
 */
public class Leetcode139WordBreak {
    // DP Approach (75.21% spd, 75.37% mem)
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wd = new HashSet<>(wordDict); // Faster access
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for(int end = 0; end <= s.length() ; end++) {
            for(int start = 0; start < end; start++) {
                // If prev word was found, check that next word is in dict
                if(dp[start] && wd.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }

        return dp[s.length()];  // Return showing we found words to fill entire string
    }
}