package interview150.ArrayAndString;

public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] == val ? 0 : 1;
        }
        int k = 0;
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right) {
            while (left <= right && nums[right] == val) {
                k++;
                right--;
            }
            while (left <= right && nums[left] != val) {
                left++;
            }
            if (left < n && right >= 0 && left <= right){
                swap(nums, left, right);
            }

        }
        return n - k;
    }

    public void swap(int[] arr, int m, int n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    public static void main(String[] args) {
        int res = new RemoveElement_27().removeElement(new int[]{3, 3}, 3);
        System.out.println(res);
    }

}
