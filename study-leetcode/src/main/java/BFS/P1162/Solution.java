package BFS.P1162;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized and return the distance.
 *
 * The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 *
 * If no land or water exists in the grid, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [[1,0,1],[0,0,0],[1,0,1]]
 * Output: 2
 * Explanation:
 * The cell (1, 1) is as far as possible from all the land with distance 2.
 * Example 2:
 *
 *
 *
 * Input: [[1,0,0],[0,0,0],[0,0,0]]
 * Output: 4
 * Explanation:
 * The cell (2, 2) is as far as possible from all the land with distance 4.
 *
 *
 * Note:
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] is 0 or 1
 */
class Solution {
    int[][] directions = new int[][] {{-1, 0},{1,0},{0,-1},{0,1}};
    public int maxDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)return -1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[0].length ; j++) {
                if(grid[i][j] == 1) {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        int level = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int[] start = queue.poll();
                int x = start[0];
                int y = start[1];
                for(int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length 
                       && !visited[newX][newY] && grid[newX][newY] == 0) {
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            level++;
        }
        return level <= 0 ? -1 : level;
    }
}