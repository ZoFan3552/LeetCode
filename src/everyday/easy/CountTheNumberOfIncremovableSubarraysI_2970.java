package everyday.easy;

import java.util.ArrayDeque;

public class CountTheNumberOfIncremovableSubarraysI_2970 {
    public int incremovableSubarrayCount(int[] nums) {
        int res = 0;
        for (int count = 1; count <= nums.length; count++) {
            int left = 0 , right = count - 1;
            while (right < nums.length) {
                boolean isIncrement = true;
                ArrayDeque<Integer> stack = new ArrayDeque<>();
                for (int i = 0; i < nums.length; i++) {
                    if (!(i >= left && i <= right)) {
                        if (stack.isEmpty()){
                            stack.push(nums[i]);
                        }else {
                            if (stack.peek() >= nums[i]) {
                                isIncrement = false;
                                break;
                            }
                            stack.push(nums[i]);
                        }
                    }
                }
                if (isIncrement) {
                    res++;
                }
                left++;
                right++;
            }
        }
        return res;
    }
}
