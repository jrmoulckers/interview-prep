import java.util.Arrays;

/**
 * Leetcode 646: Maximum Length of Pair Chain (MEDIUM)
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 *
 * You are given n pairs of numbers. In every pair, the first number is always
 * smaller than the second number.
 * 
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b
 * < c. Chain of pairs can be formed in this fashion.
 * 
 * Given a set of pairs, find the length longest chain which can be formed. You
 * needn't use up all the given pairs. You can select pairs in any order.
 * 
 * Example 1: Input: [[1,2], [2,3], [3,4]] Output: 2 Explanation: The longest
 * chain is [1,2] -> [3,4]
 * 
 * Note: The number of given pairs will be in the range [1, 1000].
 */
public class Leetcode646MaximumLengthOfPairChain {

    // Dynamic programming approach (41.82% spd, 79.55% mem)
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int[] chainLengths = new int[pairs.length];
        Arrays.fill(chainLengths, 1); // Always a chain of at least one

        // Chain can only occur in sorted order
        for(int j = 1; j < pairs.length; j++) {
            for(int i = 0; i < j; i++) {
                // Check if we can extend the chain
                if(pairs[i][1] < pairs[j][0]) {
                    // Update longest chain up to this index if it is larger
                    chainLengths[j] = Math.max(chainLengths[j], chainLengths[i] + 1);
                }
            }
        }

        // Find the longest chain
        int max = 0;
        for(int len : chainLengths) {
            max = Math.max(max, len);
        }

        return max;
    }
}