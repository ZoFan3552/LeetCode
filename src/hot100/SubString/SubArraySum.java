package hot100.SubString;

import java.util.HashMap;

public class SubArraySum {
    /*
     * 创建一个HashMap命名为preSumMap，键是前缀和，值是该前缀和出现的次数。初始时，将前缀和0（没有任何元素时的前缀和）和它的计数1放入map中。
     * 遍历数组nums中的每个元素num：
     * 将当前元素num加到preSum上，得到到当前元素为止的前缀和。
     * 检查preSumMap中是否存在键为preSum - k的项。如果存在，说明找到了一个和为k的子数组，将该键对应的值（即出现次数）加到count上。
     * 更新preSumMap，将当前的preSum作为键，值为其出现次数（如果preSum已经存在，就在原有的基础上加1，否则添加新的键值对，值为1）。
     * 遍历完成后，count变量中存储的就是满足条件的子数组的总数。方法最终返回count
     * 在初始添加(0,1)是为了验证在前缀和为空时，数组里恰好有大小为K的子数组时
     * 例如，如果数组是[1, 2, 3]，并且k是3，没有(0, 1)的情况下，我们会错过计数[1, 2]这个子数组，因为此时的preSum == 1 + 2 == 3，preSum - k == 0。
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 前缀和的思想
        int count = 0;
        int preSum = 0;
        HashMap<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        for (int num : nums) {
            preSum += num;
            if (preSumMap.containsKey(preSum - k)) {
                count += preSumMap.get(preSum - k);
            }

            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int i = new SubArraySum().subarraySum(new int[]{1,2,3,4,5,6,7,1,23,21,3,1,2,1,1,1,1,1,12,2,3,2,3,2,2}, 12);
        System.out.println(i);
    }
}
