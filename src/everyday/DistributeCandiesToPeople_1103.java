package everyday;

import java.util.Arrays;

/**
 * 排排坐，分糖果。
 * <p>
 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 * <p>
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 * <p>
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 * <p>
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
 * <p>
 * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
 */
public class DistributeCandiesToPeople_1103 {

    public int[] distributeCandies(int candies, int n) {
        int[] ans = new int[n];
        //等差数列先求出能分的轮数
        int round = 0;
        int a0 = 1, an = a0 + n - 1;
        while (true) {
            int sum = n * (a0 + an) / 2;
            if (candies >= sum) {
                round++;
                candies -= sum;
            } else {
                break;
            }
            a0 = an + 1;
            an = a0 + n - 1;
        }
        int _a0 = 1, _an = _a0 + n - 1;
        for (int i = 0; i < round; i++) {
            for (int j = 0; j < n; j++) {
                ans[j] += (_a0 + j);
            }
            _a0 = _an + 1;
            _an = _a0 + n - 1;
        }
        for (int i = 0; i < n; i++) {
            if (candies <= (_a0 + i)) {
                ans[i] += candies;
                break;
            } else {
                candies -= (_a0 + i);
                ans[i] += (_a0 + i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] res = new DistributeCandiesToPeople_1103().distributeCandies(60, 4);
        System.out.println(Arrays.toString(res));
    }
}
