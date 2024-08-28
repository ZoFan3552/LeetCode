package hot100.Tricks;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库内置的 AlgorithmTemplate.sort 函数的情况下解决这个问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 */
public class SortColors {
    public void sortColors(int[] nums) {
/*        计数排序
        int red = 0;
        int white = 0;
        int blue = 0;
        for (int num : nums) {
            if(num == 0){
                red++;
            } else if (num == 1) {
                white++;
            } else if (num == 2) {
                blue++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < red){
                nums[i] = 0;
            }else if (i < red + white){
                nums[i] = 1;
            }else {
                nums[i] = 2;
            }
        }*/
        //赋值操作
        int redIndex = 0 , whiteIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            nums[i] = 2;
            if (num == 0){
                nums[redIndex++] = 0;
            } else if (num == 1) {
                nums[whiteIndex++] = 1;
            }
        }
    }
}
