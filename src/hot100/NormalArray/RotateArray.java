package hot100.NormalArray;

public class RotateArray {
    /*
    给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
    示例 1:

    输入: nums = [1,2,3,4,5,6,7], k = 3
    输出: [5,6,7,1,2,3,4]
    解释:
    向右轮转 1 步: [7,1,2,3,4,5,6]
    向右轮转 2 步: [6,7,1,2,3,4,5]
    向右轮转 3 步: [5,6,7,1,2,3,4]
    示例 2:

    输入：nums = [-1,-100,3,99], k = 2
    输出：[3,99,-1,-100]
    解释:
    向右轮转 1 步: [99,-1,-100,3]
    向右轮转 2 步: [3,99,-1,-100]
     */
    //1.数组翻转
    /*
    nums = "----->-->"; k =3
    result = "-->----->";
    reverse "----->-->" we can get "<--<-----"
    reverse "<--" we can get "--><-----"
    reverse "<-----" we can get "-->----->"
    this visualization help me figure it out :)
    */
    //2.使用额外的数组（队列）
    //3.环状替换
    public void rotate(int[] nums, int k) {
        k = k % nums.length;//这里用取模运算的原因是以为K有可能大于数组程度，导致重复移动
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        new RotateArray().rotate(new int[]{-1, -100, 3, 99}, 2);
    }
}
