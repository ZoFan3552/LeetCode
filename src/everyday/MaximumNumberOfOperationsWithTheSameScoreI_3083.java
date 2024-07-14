package everyday;

public class MaximumNumberOfOperationsWithTheSameScoreI_3083 {
    public int maxOperations(int[] nums) {
        if(nums.length < 2) return 0;
        int times = 1;
        int sum = nums[0] + nums[1];
        int p1 = 2, p2 = 3;
        while (p1 < nums.length && p2 < nums.length){
            if (nums[p1] + nums[p2] == sum){
                times++;
            }else {
                break;
            }
            p1 += 2;
            p2 += 2;
        }
        return times;
    }
}
