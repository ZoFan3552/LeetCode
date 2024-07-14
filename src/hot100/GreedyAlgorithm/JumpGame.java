package hot100.GreedyAlgorithm;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length == 1){
            return true;
        }
        int futureMaxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && futureMaxPosition <= i){
                if (i != nums.length - 1){
                    return false;
                }
                break;
            }
            futureMaxPosition = Math.max(futureMaxPosition, nums[i] + i);
            if (futureMaxPosition >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
