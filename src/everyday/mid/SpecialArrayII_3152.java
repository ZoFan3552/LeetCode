package everyday.mid;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/14 下午1:31
 */
public class SpecialArrayII_3152 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean[] isSpecial = new boolean[n - 1];
        int[] prefixSpecial = new int[n];

        // 预处理：生成 isSpecial 数组
        for (int i = 0; i < n - 1; i++) {
            if ((nums[i] & 1) != (nums[i + 1] & 1)) {//判断相邻的两个奇偶性
                isSpecial[i] = true;
            }
        }

        // 生成 prefixSpecial 数组
        for (int i = 1; i < n; i++) {
            if (isSpecial[i - 1]){
                prefixSpecial[i] = prefixSpecial[i - 1] + 1;
            }
        }

        boolean[] answer = new boolean[queries.length];

        // 查询处理
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];

            if (to == from) {
                // 单个元素为特殊数组
                answer[i] = true;
            } else {
                int specialPairs = prefixSpecial[to] - prefixSpecial[from];
                // 如果 specialPairs 数量等于 (to - from)，则表示所有相邻元素都是奇偶不同
                if (specialPairs == to - from){
                    answer[i] = true;
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {

        boolean[] res = new SpecialArrayII_3152().isArraySpecial(new int[]{4, 3, 1, 6}, new int[][]{{0, 2}, {2, 3}});
        System.out.println(Arrays.toString(res));
    }
}
