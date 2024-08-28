package algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static void quickSort(int[] nums , int left , int right){
        //子数组长度为1时终止
        if (left >= right){
            return;
        }
        int pivot = partition(nums , left , right);
        //递归左右子数组
        quickSort(nums , left , pivot - 1);
        quickSort(nums , pivot + 1 , right);
    }

    //哨兵划分
    public static int partition(int[] nums , int left , int right){
        //以nums[left]基准数
        int i = left , j = right;
        while (i < j){
            while (i < j && nums[j] >= nums[left]){
                //从右向左找到首个比基准元素小的
                j--;
            }
            while (i < j && nums[i] <= nums[left]){
                //从左到右找到首个比基准元素大的
                i++;
            }
            swap(nums , i , j);//交换这两个元素
        }
        swap(nums , i , left);//将基准数交换至两个数组的边界
        return i;//返回基准数的索引
    }

    public static void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,7,9,5,11,22};
        quickSort(nums , 0 , nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
