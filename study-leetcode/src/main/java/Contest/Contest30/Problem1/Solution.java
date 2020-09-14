package Contest.Contest30.Problem1;

/**
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
 *
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
 *
 *
 *
 * 示例 1：
 *
 * 输入：mat = [[1,0,0],
 *             [0,0,1],
 *             [1,0,0]]
 * 输出：1
 * 解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
 * 示例 2：
 *
 * 输入：mat = [[1,0,0],
 *             [0,1,0],
 *             [0,0,1]]
 * 输出：3
 * 解释：(0,0), (1,1) 和 (2,2) 都是特殊位置
 * 示例 3：
 *
 * 输入：mat = [[0,0,0,1],
 *             [1,0,0,0],
 *             [0,1,1,0],
 *             [0,0,0,0]]
 * 输出：2
 * 示例 4：
 *
 * 输入：mat = [[0,0,0,0,0],
 *             [1,0,0,0,0],
 *             [0,1,0,0,0],
 *             [0,0,1,0,0],
 *             [0,0,0,1,1]]
 * 输出：3
 *
 *
 * 提示：
 *
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] 是 0 或 1
 */
class Solution {
    public int numSpecial(int[][] mat) {
        int result=0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j]==1) {
                    //判断左右和上下是否都是0
                    int col=0,bottom=0;
                    for (int k = 0; k < mat[i].length; k++) {
                        if (mat[i][k]==1) {
                            col++;
                        }
                    }
                    for (int k = 0; k < mat.length; k++) {
                        if (mat[k][j]==1) {
                            bottom++;
                        }
                    }
                    if (col==1 && bottom==1) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSpecial(new int[][]{{1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}}));

        System.out.println(new Solution().numSpecial(new int[][]{{1,0,0},
                {0,1,0},
                {0,0,1}}));

        System.out.println(new Solution().numSpecial(new int[][]{{0,0,0,1},
                {1,0,0,0},
                {0,1,1,0},
                {0,0,0,0}}));

        System.out.println(new Solution().numSpecial(new int[][]{{0,0,0,0,0},
              {1,0,0,0,0},
                {0,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,1}}));
    }
}