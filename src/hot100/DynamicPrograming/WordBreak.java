package hot100.DynamicPrograming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        //完全背包问题
        int capacity = s.length();
        HashSet<String> prefixSets = new HashSet<>(wordDict);
        boolean[] dp = new boolean[capacity + 1];
        dp[0] = true;//空字符串是可以被分解的
        for (int i = 1; i <= capacity; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && prefixSets.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[capacity];
    }
}
