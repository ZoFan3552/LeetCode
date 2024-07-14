package hot100.BinarySearch;

public class SearchInsertPos {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;//如果没找到，则left就是最终的逼近位置
    }


    public static void main(String[] args) {
        new SearchInsertPos().searchInsert(new int[]{1, 2, 4, 5}, 3);
    }
}
