package hot100.DynamicPrograming;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 *
 *
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * 子集和相等问题（Partition Problem）
 * 子集和相等问题是一个特例，它询问是否可以将一个集合划分为两个子集，使得这两个子集的和相等。这也是一个NP完全问题。一个常见的判断方法是：
 * <p>
 * 计算整个集合的和S。
 * 如果S是奇数，直接得出结论不存在这样的划分，因为两个相等的整数相加不可能是奇数。
 * 如果S是偶数，设S/2 = K，然后在集合中查找是否存在一个子集和为K。
 *
 * 本题还可以转换为 0-1 背包问题
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0){
            return false;
        }
        int target = sum / 2;

        /*
        dp数组含义：
        dp[i]表示对于不加入当前数num的情况,是否存在一个子集的和为i
        dp[i - num]表示在加入当前元素num后，我们能否找到和为i的子集*/

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for(int i = target; i >= num; i--) {
                if (dp[target]){
                    return true;
                }
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }

    public boolean canPartition2(int[] objects) {
        int sum = 0;
        for (int num : objects) {
            sum += num;
        }
        if (sum % 2 != 0){
            return false;
        }
        int capacity = sum / 2;
        /*
         * 转换为0-1背包问题
         */
        int[][] dp = new int[objects.length + 1][capacity + 1];
        for (int i = 1; i <= objects.length; i++) {//物品重量为0以及背包容量为0时初始化为0,所以两层循环都从1开始
            for(int curCapacity = 1; curCapacity <= capacity; curCapacity++) {
                if(objects[i - 1] <= curCapacity){
                    dp[i][curCapacity] = Math.max(dp[i-1][curCapacity] , dp[i-1][curCapacity-objects[i - 1]] + objects[i - 1]);
                }else {
                    dp[i][curCapacity] = dp[i-1][curCapacity];
                }
            }
        }

        return dp[objects.length][capacity] == capacity;
    }

    public static void main(String[] args) {
        boolean res = new PartitionEqualSubsetSum().canPartition2(new int[]{1,5,11,5});
        System.out.println(res);
    }
}
