package hot100.BinarySearch;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*
           假设数组1为：A0 A1 A2 ... Am1-1 Am1 ... An1-1
           假设数组2为：B0 B1 B2 ... Bm2-1 Bm2 ... Bn2-1
           合并后有 n1 + n2 - 1 个元素 且前k个元素为[A0 ... Am1-1] + [B0 ... Bm2-1]
           假设合并后数组为：C0 C1 C2 ... Ck-1 Ck ... Cn1+n2-1
           若总长度为偶数，则中位数为 (Ck-1 + Ck) / 2 ;若为奇数，则中位数为 Ck-1
           则有如下数学表示
           m1 + m2 = k = (n1 + n2 + 1) / 2，n1为数组1的长度 n2为数组2的长度
           中位数一定来自于{Am1-1 , Bm2-1 , Am1 , Bm2}
           我们只对长度最小的数组进行二分搜索，即时间复杂度为O(log(min(m,n)))
           总点在于在合并后的数组中找到这四个元素
           Ck-1 = max(Am1-1 ,Bm2-1)
           Ck = min(Am1 ,Bm2)

           用一个例子说明
           假设数组1为：-1 1 3 5 7 9
           假设数组2为：2 4 6 8 10 12 14 16
           则 n1 = 6 ,n2 = 8 , k = (n1 + n2 + 1 ) / 2 = 7
           则 m1 = 4 , m2 = 3
           合并后的长度为14 为偶数
           则Ck-1 = max(Am1-1 ,Bm2-1) = max(5 , 6) = 6
           则Ck = min(Am1 ,Bm2) = min(7 , 8) = 7
           median = (Ck-1 + Ck) / 2.0 = (6 + 7 ) /2.0 = 3.5
           循环过程的真值表为
           while(l < r) l=0,r=n1=6,k =  (6 + 8 + 1) / 2 = 7
           m1 = (l + r) / 2 , m2 = k - m1

           l  r  m1  m2  A[m1]  B[m2-1]  C
           0  6  3   4   5      10       <
           4  6  5   2   9      4        >
           4  5  4   3   7      6        >
           4  4  -   -   -      -        -
         */
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) {//保证n1的长度小于n2的长度
            return findMedianSortedArrays(nums2, nums1);
        }


        int k = (n1 + n2 + 1) >> 1;//加1是为了保证数组和的奇偶结果一致（边界条件1）

        //因为只对长度较小的一个数组进行二分搜索，所以只用一个左指针和一个右指针
        int l = 0;
        int r = n1;

        while (l < r) {
            int m1 = l + ((r - l) >> 1);
            int m2 = k - m1;

            if (nums1[m1] < nums2[m2 - 1]) {
                l = m1 + 1;
            } else {
                r = m1;
            }
        }
        int m1 = l;
        int m2 = k - l;
        //注意处理越界情况，一般是其中一个数组长度为0 或 远远小于另一个数组时
        //对于越界的我们直接取 正无穷 或 负无穷
        //Ck-1 = max(Am1-1 ,Bm2-1)
        int Ck_1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1], m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
        if ((n1 + n2) % 2 == 1) {
            return Ck_1;
        }
        //Ck = min(Am1 ,Bm2)
        int Ck = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1], m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
        return (Ck_1 + Ck) / 2.0;
    }

    public static void main(String[] args) {
        double medianSortedArrays = new MedianOfTwoSortedArray().findMedianSortedArrays(new int[]{}, new int[]{2, 3});
        System.out.println(medianSortedArrays);
    }
}
