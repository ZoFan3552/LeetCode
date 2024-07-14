package hot100.SortAlgorithm;

import java.util.Arrays;

public class QuickSort {

    int medianThree(int[] nums, int left, int mid, int right) {
        int l = nums[left], m = nums[mid], r = nums[right];
        if ((l <= m && m <= r) || (r <= m && m <= l))
            return mid; // m 在 l 和 r 之间
        if ((m <= l && l <= r) || (r <= l && l <= m))
            return left; // l 在 m 和 r 之间
        return right;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 首先，对原数组执行一次“哨兵划分”，得到未排序的左子数组和右子数组。
     * 然后，对左子数组和右子数组分别递归执行“哨兵划分”。
     * 持续递归，直至子数组长度为 1 时终止，从而完成整个数组的排序。
     * 后续的优化可以选取首端 中间 末端的中位数作为基准数，防止出现极端情况（数组完全有序）导致快排退化为O(n ^ 2)
     */
    public int partition(int[] arr, int left, int right) {
        // 选取三个候选元素的中位数
        int med = medianThree(arr, left, (left + right) / 2, right);
        swap(arr, med , left);
        //以 nums[left] 为基准数
        int leftPointer = left , rightPointer = right;
        while (leftPointer < rightPointer) {
            //从右向左找到第一个小于基准数的元素
            while (leftPointer < rightPointer && arr[rightPointer] >= arr[left]){
                rightPointer--;
            }
            //从左向右找到第一个大于基准数的元素
            while (leftPointer < rightPointer && arr[leftPointer] <= arr[left]){
                leftPointer++;
            }
            //交换这两个元素
            swap(arr, leftPointer, rightPointer);
        }
        //将基准数交换至两个子数组的分界线
        swap(arr, leftPointer, left);
        return leftPointer;//返回基准数的索引
    }

    public void quickSort(int[] arr, int left, int right) {
        if(left >= right) return;//序列长度为1时结束递归
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);//对左子序列进行快排
        quickSort(arr, pivot + 1, right);//对右子序列进行快排
    }

}
