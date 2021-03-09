package String.P5;

/**
 * 马拉车算法找最长回文子串
 * 算法时间复杂度O(n)
 * @author yeqiaozhu.
 * @date 3/9/21
 */
public class Manacher {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        char[] chars = manacherString(s);
        int n = chars.length;
        int[] pArr = new int[n];
        int C = -1, R = -1, pos = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            pArr[i] = i < R ? Math.min(pArr[C * 2 - i], R - i) : 1;
            while (i + pArr[i] < n && i - pArr[i] > -1) {
                if (chars[i + pArr[i]] == chars[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            if (pArr[i] > max) {
                max = pArr[i];
                pos = i;
            }
        }
        int offset = pArr[pos];
        StringBuilder sb = new StringBuilder();
        for (int i = pos - offset + 1; i <= pos + offset - 1; i++) {
            if (chars[i] != '#') {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
    char[] manacherString(String s) {
        char[] chars = new char[s.length() * 2 + 1];
        for (int i = 0, idx = 0; i < chars.length; i++) {
            chars[i] = (i & 1) == 0 ? '#' : s.charAt(idx++);
        }
        return chars;
    }
}
