package hot100.BinarySearch;

public class FirstAndLastInArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        /*

        在一个范围内，查找一个数字，要求找到这个元素的开始位置和结束位置，这个范围内的数字都是单调递增的，即具有单调性质，因此可以使用二分来做。
        两次二分，第一次二分查找第一个>=target的位置，第二次二分查找最后一个<=target的位置。查找成功则返回两个位置下标，否则返回[−1,−1][-1,-1][−1,−1]。

         */
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = ((right + left) >> 1);
            if (nums[mid] >= target) {
                right = mid;//收缩右边界
            }else {
                left = mid + 1;
            }
        }
        if(nums[right] != target){
            return new int[]{-1, -1};
        }
        int Left = right;
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = ((right + left + 1) >> 1);
            if (nums[mid] <= target) {
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        return new int[]{Left, right};
    }

}
