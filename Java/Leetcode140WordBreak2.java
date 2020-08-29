import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Leetcode 140: Word Break 2 (HARD)
 * https://leetcode.com/problems/word-break-2/
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word. 
 * Return all such possible sentences.
 * 
 * Note:
 *  The same word in the dictionary may be reused multiple times in the segmentation.
 *  You may assume the dictionary does not contain duplicate words.
 * 
 * Example 1:
 *  Input:
 *   s = "catsanddog"
 *   wordDict = ["cat", "cats", "and", "sand", "dog"]
 *  Output:
 *   [
 *     "cats and dog",
 *     "cat sand dog"
 *   ]
 * 
 * Example 2:
 *  Input:
 *   s = "pineapplepenapple"
 *   wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 *  Output:
 *   [
 *     "pine apple pen apple",
 *     "pineapple pen apple",
 *     "pine applepen apple"
 *   ]
 *   Explanation: Note that you are allowed to reuse a dictionary word.
 * 
 * Example 3:
 *  Input:
 *   s = "catsandog"
 *   wordDict = ["cats", "dog", "sand", "and", "cat"]
 *  Output:
 *   []
 */
public class Leetcode140WordBreak2 {
    // DP Approach, DFS with recursive backtracking (80.34% spd, 88.17% mem)
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> wd = new HashSet<>(wordDict);

        // Perform recursive (with early termination) depth first search for values
        return dfs(s, wd, new HashMap<>());
    }

    public List<String> dfs(String s, HashSet<String> wd, HashMap<String, List<String>> mem) {
        // Base case, already found value. Return
        if(mem.containsKey(s)) {
            return mem.get(s);
        }

        List<String> result = new ArrayList<>();
        // Base case: return empty list if null or empty string
        if(s == null || s.length() == 0) {
            return result;
        }
        int len = s.length();
        // Check every word in dictionary to see if it matches beginning of string
        for(String word : wd) {
            if(!s.startsWith(word)) {
                continue; // Move on if not
            }
            int end = word.length();
            // Add to result if this is the final word in the string
            if(end == len) {
                result.add(word);
            } else {
                // Otherwise, dfs on subsequent words
                List<String> sublist = dfs(s.substring(end), wd, mem);
                // Add all items in result to this word to form sentence
                for(String item : sublist) {
                    item = word + " " + item;
                    result.add(item);
                }
            }
        }

        // Put this word back into memory for the starting word we used
        mem.put(s, result);
        return result;
    }
}