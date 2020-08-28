import java.util.List;

/**
 * Leetcode 120: Triangle (MEDIUM)
 * https://leetcode.com/problems/triangle/
 * 
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 *  Bonus point if you are able to do this using only O(n) extra space, 
 *  where n is the total number of rows in the triangle.
 */
public class Leetcode120Triangle {
    // DP Approach: walking up the pyramid (44.92% spd, 80.99% mem)
    public int minimumTotal(List<List<Integer>> triangle) {
        // Bottom up: combine walking up the pyramid
        for(int i = triangle.size() - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                // Find minimum of two descendents, add to current value
                triangle.get(i).set(j, triangle.get(i).get(j) +  Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }
}