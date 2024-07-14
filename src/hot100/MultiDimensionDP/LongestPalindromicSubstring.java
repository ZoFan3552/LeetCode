package hot100.MultiDimensionDP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLen = 1;
        for (int i = 0; i < n; i++) {//单个字符一定是回文
            dp[i][i] = true;
        }
        for (int i = 0; i < n-1; i++) {//查看相邻两个字符是否为回文
            if (s.charAt(i) == s.charAt(i + 1)){
                dp[i][i+1] = true;
                start = i;
                maxLen = 2;
            }
        }

        //dp[i][j]表示从索引i到索引j的字符串是否为回文串，如果s[i]==s[j]且boolean[i+1][j-1]为true,则boolean[i][j]为true
        for (int len = 3;len <= n;len++){//检查长度为3的字符串
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;//字符串的结束位置
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    start = i;
                    maxLen = len;
                }
            }
        }
        return s.substring(start , start + maxLen);
    }
}
