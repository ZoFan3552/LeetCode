package everyday.easy;

import java.util.Arrays;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/1 上午11:44
 */
public class MentalArithmeticChallenge_LCP40 {
    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int n = cards.length;
        int maxScore = 0;
        for (int i = n - cnt; i < n; i++) {
            maxScore += cards[i]; // 最大的 cnt 个数之和
        }
        if (maxScore % 2 == 0) { // maxScore 是偶数
            return maxScore;
        }

        int x = cards[n - cnt];
        int res = replaceNum(cards, cnt, maxScore, x); // 替换掉 x
        for (int i = n - cnt + 1; i < n; i++) {
            if ((cards[i] & 1) != (x & 1)) { // 找到一个最小的奇偶性和 x 不同的数
                res = Math.max(res, replaceNum(cards, cnt, maxScore, cards[i])); // 替换
                break;
            }
        }
        return res;
    }

    private int replaceNum(int[] cards, int cnt, int maxScore, int x) {
        for (int i = cards.length - cnt - 1; i >= 0; i--) {
            if ((cards[i] & 1) != (x & 1)) { // 找到一个最大的奇偶性和 x 不同的数
                return maxScore - x + cards[i]; // 用 cards[i] 替换 maxScore
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int res = new MentalArithmeticChallenge_LCP40().maxmiumScore(new int[]{9,5,9,1,6,10,3,4,5,}, 2);
        System.out.println(res);
    }
}
