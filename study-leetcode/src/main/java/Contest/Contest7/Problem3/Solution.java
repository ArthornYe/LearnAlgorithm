package Contest.Contest7.Problem3;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个只包含 0 和 1 的 rows * columns 矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：mat = [[1,0,1],
 *             [1,1,0],
 *             [1,1,0]]
 * 输出：13
 * 解释：
 * 有 6 个 1x1 的矩形。
 * 有 2 个 1x2 的矩形。
 * 有 3 个 2x1 的矩形。
 * 有 1 个 2x2 的矩形。
 * 有 1 个 3x1 的矩形。
 * 矩形数目总共 = 6 + 2 + 3 + 1 + 1 = 13 。
 * 示例 2：
 *
 * 输入：mat = [[0,1,1,0],
 *             [0,1,1,1],
 *             [1,1,1,0]]
 * 输出：24
 * 解释：
 * 有 8 个 1x1 的子矩形。
 * 有 5 个 1x2 的子矩形。
 * 有 2 个 1x3 的子矩形。
 * 有 4 个 2x1 的子矩形。
 * 有 2 个 2x2 的子矩形。
 * 有 2 个 3x1 的子矩形。
 * 有 1 个 3x2 的子矩形。
 * 矩形数目总共 = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24 。
 * 示例 3：
 *
 * 输入：mat = [[1,1,1,1,1,1]]
 * 输出：21
 * 示例 4：
 *
 * 输入：mat = [[1,0,1],[0,1,0],[1,0,1]]
 * 输出：5
 *
 *
 * 提示：
 *
 * 1 <= rows <= 150
 * 1 <= columns <= 150
 * 0 <= mat[i][j] <= 1
 */
class Solution {
    public int numSubmat(int[][] mat) {
        int[][] dp=new int[mat.length][mat[0].length];
        int sum=0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i==0 || j==0){
                    dp[i][j]=mat[i][j];
                }else if (mat[i][j]==0) {
                    continue;
                }else {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
                sum+=dp[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> list= new ArrayList<>();
        list.add(1);
        System.out.println(list.subList(0, 1));
        System.out.println(new Solution().numSubmat(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(new Solution().numSubmat(new int[][]{{0,0,0},{0,0,0},{0,1,1},{1,1,0},{0,1,1}}));
        System.out.println(new Solution().numSubmat(new int[][]{{0,1,1,0}, {0,1,1,1}, {1,1,1,0}}));
        System.out.println(new Solution().numSubmat(new int[][]{{1,1,1,1,1,1}}));
        System.out.println(new Solution().numSubmat(new int[][]{{1,0,1},{0,1,0},{1,0,1}}));
    }
}