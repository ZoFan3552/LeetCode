package interview150.SlideWindow;

public class MinimumSizeSubarraySum_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int[] preSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < preSum.length; i++) {
            sum += nums[i];
            preSum[i] = sum;
        }
        if (preSum[preSum.length - 1] < target){
            return 0;
        }
        int left = 0 , right = left;
        while (right < nums.length && left <= right){
            int curSum;
            if (left == right){
                curSum = nums[left];
            }else if (left == 0){
                curSum = preSum[right];
            }else {
                curSum = preSum[right] - preSum[left - 1];
            }
            if (curSum >= target){//大于target的就缩小窗口
                res = Math.min(res , right - left + 1);
                left++;
            }else {//小于target就扩大窗口
                right++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int res = new MinimumSizeSubarraySum_209().minSubArrayLen(11, new int[]{1, 2, 3, 4, 5});
        System.out.println(res);
    }
}
