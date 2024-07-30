package interview150.DynamicPrograming;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/25 下午12:30
 */
public class LongestPalindromicSubstring_5 {
    //动态规划版本
    public String longestPalindrome(String s){
        if (s == null || s.isEmpty()) return "";
        if (s.length() == 1) return s;
        //i...j的字符串是否为子串
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLen = 0;
        int start = 0;
        //单个字符的 dp[i][i]
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        //两个字符的 dp[i][i+1]
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }
        //长度超过2的字符串
        for (int curLen = 3; curLen <= s.length(); curLen++) {
            for (int head = 0; head < s.length() - curLen + 1; head++) {
                int tail = head + curLen - 1;//计算子串结束位置
                // 检查当前子串的首尾字符是否相等，并且去掉首尾后的子串是否为回文
                if (s.charAt(head) == s.charAt(tail) && dp[head + 1][tail - 1]) {
                    dp[head][tail] = true;
                    start = head;
                    maxLen = curLen;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
    //中心扩展版本
//    /**
//     * 找到给定字符串中的最长回文子串。
//     *
//     * @param s 输入字符串。
//     * @return 最长回文子串。
//     */
//    public  String longestPalindrome(String s) {
//        if (s == null || s.isEmpty()) {
//            return "";
//        }
//
//        int start = 0, end = 0;
//
//        // 遍历每个字符，尝试以其为中心扩展回文子串
//        for (int i = 0; i < s.length(); i++) {
//            int oddLen = expandAroundCenter(s, i, i);     // 检查奇数长度的回文
//            int evenLen = expandAroundCenter(s, i, i + 1); // 检查偶数长度的回文
//            int len = Math.max(oddLen, evenLen);
//
//            // 如果找到更长的回文子串，则更新起始和结束位置
//            if (len > end - start) {
//                start = i - (len - 1) / 2;
//                end = i + len / 2;
//            }
//        }
//
//        return s.substring(start, end + 1);
//    }
//
//    /**
//     * 从中心扩展以找到回文的长度。
//     *
//     * @param s 输入字符串。
//     * @param left 中心的左索引。
//     * @param right 中心的右索引。
//     * @return 回文子串的长度。
//     */
//    private  int expandAroundCenter(String s, int left, int right) {
//        int L = left, R = right;
//
//        // 向两边扩展，检查字符是否相等
//        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
//            L--;
//            R++;
//        }
//
//        return R - L - 1;
//    }
}
