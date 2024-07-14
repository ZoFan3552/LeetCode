package everyday;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumNumberofOperationsWiththeSameScoreII_3040 {

    int maxTimes = 1;
    Map<String, Integer> memo = new HashMap<>();//记忆化搜索防止计算重复项

    public int maxOperations(int[] nums) {
        int start = 0 , end = nums.length - 1;
        int sum1 = nums[start] + nums[start + 1];
        int sum2 = nums[start] + nums[end];
        int sum3 = nums[end] + nums[end - 1];
        DFS(nums , sum1 , start + 2 , end , 1);
        DFS(nums , sum2 , start + 1 , end - 1 , 1);
        DFS(nums , sum3 , start , end - 2 , 1);
        return maxTimes;
    }

    public void DFS(int[] nums, int sum, int start, int end, int times) {
        if (!(start < end)) return;

        // Check if we have already computed the maximum times for the current state
        String key = start + "," + end;
        if (memo.containsKey(key) && memo.get(key) >= times) return;
        memo.put(key, times);

        int sum1Times = times;
        int sum2Times = times;
        int sum3Times = times;

        if (start + 1 < nums.length){
            int sum1 = nums[start] + nums[start + 1];
            if (sum1 == sum){
                sum1Times++;
                maxTimes = Math.max(sum1Times , maxTimes);
                DFS(nums, sum1, start + 2, end, sum1Times);
            }
        }

        int sum2 = nums[start] + nums[end];
        int sum3 = nums[end] + nums[end - 1];

        if (sum2 == sum){
            sum2Times++;
            maxTimes = Math.max(sum2Times , maxTimes);
            DFS(nums, sum2, start + 1, end - 1, sum2Times);
        }

        if (sum3 == sum){
            sum3Times++;
            maxTimes = Math.max(sum3Times , maxTimes);
            DFS(nums, sum3, start, end - 2, sum3Times);
        }
    }


}
