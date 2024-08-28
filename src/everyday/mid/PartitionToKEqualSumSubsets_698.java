package everyday.mid;

import java.util.Arrays;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/25 下午9:59
 */
public class PartitionToKEqualSumSubsets_698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum % k != 0) return false;
        int target = sum / k;

        Arrays.sort(nums);
        int n = nums.length;
        if(nums[n - 1] > target) return false;

        boolean[] visited = new boolean[n];
        return canPartition(nums , visited , k , 0 , 0 , target);
    }

    private boolean canPartition(int[] nums , boolean[] visited , int k , int start , int currentSum , int target){
        if(k == 0) return true;
        if(currentSum == target) return canPartition(nums , visited , k - 1  , 0 , 0 , target);

        for (int i = start; i < nums.length; i++) {
            if(visited[i] || currentSum + nums[i] > target) continue;
            visited[i] = true;
            if(canPartition(nums , visited , k , i + 1 , currentSum + nums[i], target)) return true;
            visited[i] = false;
        }
        return false;
    }
}
