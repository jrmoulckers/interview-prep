/**
 * Leetcode 1254: Number of Closed Islands (HARD)
 * https://leetcode.com/problems/number-of-closed-islands/
 * 
 * Given a 2D grid consists of 0s (land) and 1s (water).  
 * An island is a maximal 4-directionally connected group of 0s and a 
 * closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 * 
 * Return the number of closed islands.
 * 
 * Example 1:
 *  Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 *  Output: 2
 *  Explanation: 
 *      Islands in gray are closed because they are completely surrounded by water (group of 1s).
 * 
 * Example 2:
 *  Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 *  Output: 1
 * 
 * Example 3:
 *  Input: grid = [[1,1,1,1,1,1,1],
 *                [1,0,0,0,0,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,1,0,1,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,0,0,0,0,1],
 *                [1,1,1,1,1,1,1]]
 *  Output: 2
 *  
 * 
 * Constraints:
 *  1 <= grid.length, grid[0].length <= 100
 *  0 <= grid[i][j] <=1
 */
public class Leetcode1254NumberOfClosedIslands {
    private boolean border = false;

    // DFS Solution (46.88% spd, 10.52% mem)
    public int closedIsland(int[][] grid) {
        int numClosed = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    dfs(grid, i, j);
                    if(!border) {
                        numClosed++;
                    }
                    border = false;
                }
            }
        }

        return numClosed;
    }

    public void dfs(int[][] grid, int i, int j) {
        // Simply return for OOB
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1) {
            return;
        }

        // Mark as having border
        if(i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
            border = true;
            return;
        }

        // Mark as discovered
        grid[i][j] = 1;

        // Now, check all adj. islands
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}