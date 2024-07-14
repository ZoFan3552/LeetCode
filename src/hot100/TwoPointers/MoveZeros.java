package hot100.TwoPointers;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public static void main(String[] args) {
        new MoveZeros().moveZeroes(new int[]{1,2,3,5,6,0,0,7,0,8,9});
    }
}
