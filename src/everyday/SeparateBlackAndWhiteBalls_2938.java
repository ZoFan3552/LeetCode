package everyday;

public class SeparateBlackAndWhiteBalls_2938 {
    public long minimumSteps(String s) {
        int n = s.length();
        char[] bolls = s.toCharArray();
        if (n == 1){
            return 0;
        }

        long[] dp = new long[n + 1];
        dp[0] = 0;
        long curBlack = 0 ;
        dp[1] = 0;
        if(bolls[0] == '1'){
            curBlack++;
        }
        for (int i = 2; i < n + 1; i++) {
            if (bolls[i - 1] == '1'){
                dp[i] = dp[i - 1];
                curBlack++;
            }else {
                dp[i] = dp[i - 1] + curBlack;
            }
        }
        return dp[n];
    }
}
