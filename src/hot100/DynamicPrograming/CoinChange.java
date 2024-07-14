package hot100.DynamicPrograming;

import java.util.Arrays;

public class CoinChange {
    /*
    给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 bagCapacity ，表示总金额。

    计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

    你可以认为每种硬币的数量是无限的。
     */
    public int coinChange(int[] coins, int bagCapacity) {
        //完全背包问题，与0-1背包问题不同的是，完全背包问题可以任意取物品
        //coin的面值就是重量，金额就是最大背包容量
        //本题coins面值为value,amount为capacity,dp[i]表示能凑出金额的最小coin数量
        int[] dp = new int[bagCapacity + 1];
        Arrays.fill(dp, bagCapacity + 1);//防止溢出，取amount + 1作为无穷大
        dp[0] = 0;
        for (int coinWeight : coins) {//先遍历背包
            for (int currentCapacity = 1; currentCapacity <= bagCapacity; currentCapacity++) {
                if (coinWeight <= currentCapacity) {
                    System.out.println("===================");
                    System.out.println("当前物品重量：" + coinWeight + "，背包容量：" + currentCapacity);
                    System.out.println("不取当前物品-背包中物品的数量：" + dp[currentCapacity]);
                    dp[currentCapacity] = Math.min(dp[currentCapacity], dp[currentCapacity - coinWeight] + 1);
                    System.out.println("取当前物品-背包中物品的数量：" + dp[currentCapacity]);
                    System.out.println("===================");
                }
            }
        }
        return dp[bagCapacity] == bagCapacity + 1 ? -1 : dp[bagCapacity];
    }

    public static void main(String[] args) {
        int res = new CoinChange().coinChange(new int[]{1, 2, 5}, 11);
        System.out.println(res);
    }
}
