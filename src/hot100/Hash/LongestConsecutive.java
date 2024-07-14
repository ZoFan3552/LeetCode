package hot100.Hash;

import java.util.*;

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            HashSet<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                numSet.add(num);
            }

            int longestStreak = 0;

            for (int num : nums) {
                // 只检查没有前驱的数字，以此作为序列的起点
                if (!numSet.contains(num - 1)) {
                    int currentNum = num;
                    int currentStreak = 1;

                    // 向上寻找连续的数字
                    while (numSet.contains(currentNum + 1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }

                    // 更新最长序列
                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }

            return longestStreak;
    }

    public static void main(String[] args) {
        int i = new LongestConsecutive().longestConsecutive(new int[]{4, 0, -4, -2, 2, 5, 2, 0, -8, -8, -8, -8, -1, 7, 4, 5, 5, -4, 6, 6, -3});
        System.out.println(i);
    }
}

