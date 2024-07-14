package everyday.easy;

public class FindPivotIndex_724 {
    public int pivotIndex(int[] nums) {
        int[] preSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i] = sum;
        }
        for (int i = 0; i < nums.length; i++) {
            int leftSum , rightSum;
            if (i == 0){
                leftSum = 0;
            }else {
                leftSum = preSum[i - 1];
            }
            rightSum = preSum[preSum.length - 1] - preSum[i];
            if (leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }
}
