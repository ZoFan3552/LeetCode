package hot100.BinarySearch;

public class FindMinInRotatedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.min(nums[0], nums[1]);
        if (nums[left] < nums[right]) {//没有旋转
            return nums[left];
        }
        while (left <= right) {//先找旋转点
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= nums[0]){
                left = mid + 1;
            }
            else if (nums[mid] < nums[0]){
                right = mid - 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int min = new FindMinInRotatedArray().findMin(new int[]{1 ,2,3});
        System.out.println(min);
    }
}
