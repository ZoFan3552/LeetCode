package hot100.BinarySearch;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        /*
        每行二分查找 冗余 可将二维矩阵看作一维矩阵
        for (int[] row : matrix) {
            if (searchInsert(row, target)) {
                return true;
            }
        }*/
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0 , right = row * col - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (matrix[mid / col][mid % col] == target) {
                return true;
            }
            else if (matrix[mid / col][mid % col] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

    public boolean searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return false;
    }
}
