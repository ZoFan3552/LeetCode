package hot100.NormalArray;

import java.util.Arrays;

public class ProductExceptSelf {
    /*
    给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。

    题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。

    请 不要使用除法，且在 O(n) 时间复杂度内完成此题。

    示例 1:

    输入: nums = [1,2,3,4]
    输出: [24,12,8,6]
    示例 2:

    输入: nums = [-1,1,0,-3,3]
    输出: [0,0,9,0,0]

     */
    public int[] productExceptSelf(int[] nums) {
        //利用左乘积数组和右乘积数组
        int[] res = new int[nums.length];
        int[] preMultiLeft = new int[nums.length];
        int[] preMultiRight = new int[nums.length];
        int multiLeft =  1;
        int multiRight =  1;
        for (int i = 0; i < nums.length; i++) {
            multiLeft *= nums[i];
            multiRight *= nums[nums.length - 1 - i];
            preMultiLeft[i] = multiLeft;
            preMultiRight[i] = multiRight;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0){
                res[i] = preMultiRight[nums.length - 1 - 1];
            }else if (i == nums.length - 1){
                res[i] = preMultiLeft[nums.length - 1 - 1];
            }else {
                res[i] = preMultiLeft[i - 1] * preMultiRight[nums.length - 1 - 1 - i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = new ProductExceptSelf().productExceptSelf(new int[]{-1,1,0,-3,3});
        System.out.println(Arrays.toString(ints));
    }
}
