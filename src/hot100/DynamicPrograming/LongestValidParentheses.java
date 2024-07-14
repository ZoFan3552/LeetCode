package hot100.DynamicPrograming;

import java.util.LinkedList;
import java.util.Stack;

public class LongestValidParentheses {
    /**
     * 只考虑右括号，因为有效括号对一定是以右括号结尾的
     */
    public int longestValidParentheses(String s) {
        char[] charArray = s.toCharArray();
        int maxLen = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < charArray.length; i++) {
            /*
            dp[i]表示以s[i]为结尾的当前子串的最长有效括号长度
            前一个字符是开括号 '('：
            这种情况下，当前闭括号与前一个开括号直接匹配成一对，形成了一个最小的有效括号对 ()。
            递推公式为：dp[i]=dp[i−2]+2
            其中 dp[i-2] 表示在这对新匹配的括号之前的最长有效括号子串长度。如果 i-2 小于0，则 dp[i-2] 视为0。
             */
            if (charArray[i] == ')') {
                if (charArray[i - 1] == '(') {
                    dp[i] = i - 2 >= 0 ? (dp[i - 2] + 2) : 2;
                }
                /*
                前一个字符也是闭括号 ')'：
                这种情况复杂一些。首先检查由当前闭括号闭合的子串的前一位是否是一个开括号，即 s[i-dp[i-1]-1] 是否是 '('。
                如果是，那么 s[i-dp[i-1]-1] 与 s[i] 匹配，形成一对括号，并将这对括号之间的有效子串（长度为 dp[i-1]）和这对之前的有效子串（长度为 dp[i-dp[i-1]-2]）相加，
                最后加上这对新匹配的括号长度2。
                递推公式为：dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
                如果 i-dp[i-1]-2 小于0，那么 dp[i-dp[i-1]-2] 视为0。
                 */
                else if (charArray[i - 1] == ')') {
                    if (i - dp[i - 1] > 0 && charArray[i - 1 - dp[i - 1]] == '(') {
                        if (i - dp[i - 1] - 2 < 0) {
                            dp[i] = dp[i - 1] + 2;
                        } else {
                            dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                        }
                    }
                }
            }
        }
        for (int max : dp) {
            maxLen = Math.max(max, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int res = new LongestValidParentheses().longestValidParentheses(")()())");
        System.out.println(res);
    }
}
