package Stack.单调栈.P84;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            arr[i] = heights[i];
        }
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for (int i = 0; i <= n; ++i) {
            while (!st.empty() && arr[st.peek()] >= arr[i]) {
                int h = arr[st.pop()];
                int len = st.empty() ? i : (i - st.peek() - 1);
                ans = Math.max(ans, h * len);
            }
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        BigDecimal test=new BigDecimal(0.0060000);
        System.out.println(test.doubleValue());
        Stack<Object> objects = new Stack<>();
        System.out.println(new Solution().largestRectangleArea(new int[]{2, 5, 4, 2, 4,5,3,1,2,4}));
        System.out.println(new Solution().largestRectangleArea(new int[]{1,1}));
    }
}