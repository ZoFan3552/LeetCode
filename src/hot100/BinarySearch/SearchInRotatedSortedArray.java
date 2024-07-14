package hot100.BinarySearch;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        // 根据target和nums[0]的关系判断是在数组的左半段还是右半段
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (target >= nums[0]){//说明在数组的左半段
                if (nums[mid] < nums[0]){
                    nums[mid] = Integer.MAX_VALUE;
                }
            }else {
                if (nums[mid] >= nums[0]){
                    nums[mid] = Integer.MIN_VALUE;
                }
            }
            if (nums[mid] < target){
                left = mid + 1;
            }
            if (nums[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }
}
