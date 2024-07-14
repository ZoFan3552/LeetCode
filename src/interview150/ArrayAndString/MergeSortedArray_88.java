package interview150.ArrayAndString;

public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0 , cur = 0;
        int[] res = new int[m + n];
        while (cur < (m + n)){
            if (p1 >= m && p2 < n){
                res[cur++] = nums2[p2++];
            }else if (p2 >= n && p1 < m){
                res[cur++] = nums1[p1++];
            }else {
                if (nums1[p1] <= nums2[p2]){
                    res[cur++] = nums1[p1++];
                }else {
                    res[cur++] = nums2[p2++];
                }
            }
        }
        if (m + n >= 0) System.arraycopy(res, 0, nums1, 0, m + n);
    }

    public static void main(String[] args) {
        new MergeSortedArray_88().merge(new int[]{4,0,0,0,0,0}, 1
                , new int[]{1,2,3,5,6}, 5);
    }
}
