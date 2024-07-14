package sort;

import java.util.Arrays;

public class MergeSort {
    public static void  mergeSort(int[] arr , int left, int right) {
        if (left < right){
            int mid  = left + ((right - left) >> 1);
            mergeSort(arr, left, mid);//分治左区间
            mergeSort(arr , mid + 1 , right);//分治右区间
            merge(arr , left , mid , right);//合并结果
        }
    }

    public static void merge(int[] arr , int left, int mid, int right) {
        int[] temp = new int[right - left + 1];//临时数组存放
        int left_P = left , right_P = mid + 1 , temp_P = 0;//初始左右区间指针

        while (left_P <= mid && right_P <= right){
            if (arr[left_P] > arr[right_P]){
                temp[temp_P] = arr[right_P];
                temp_P++;
                right_P++;
            }else {
                temp[temp_P] = arr[left_P];
                temp_P++;
                left_P++;
            }
        }
        //把剩余的复制到temp
        while (left_P <= mid){
            temp[temp_P] = arr[left_P];
            temp_P++;
            left_P++;
        }

        while (right_P <= right){
            temp[temp_P] = arr[right_P];
            temp_P++;
            right_P++;
        }
        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6,9,10,7};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
