package hot100.MultiDimensionDP;

import java.util.HashSet;

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        char[] word1CharArray = word1.toCharArray();
        char[] word2CharArray = word2.toCharArray();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {//初始化删除次数
            dp[i][0] = i;
        }
        for (int i = 0; i <= length2; i++) {//初始化插入次数
            dp[0][i] = i;
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1CharArray[i - 1] == word2CharArray[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];//在dp[i-1][j-1]的基础上不用做任何操作
                } else {
                    dp[i][j] = Math.min(Math.min(
                            dp[i - 1][j] + 1, //删除
                            dp[i - 1][j - 1] + 1),//替换
                            dp[i][j - 1] + 1);//插入
                }

            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        int res = new EditDistance().minDistance("intention", "execution");
        System.out.println(res);
    }


}
