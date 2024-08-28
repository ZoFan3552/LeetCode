package chanllenge119;

import java.util.*;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/27 下午4:04
 */
public class LCR007_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
       for (int i = 0; i < nums.length - 2; i++) {
           if(i > 0 && nums[i] == nums[i-1]) continue;
           if (nums[i] > 0) break;
           int left = i + 1, right = nums.length - 1;
           while (left < right){
               int sum = nums[i] + nums[left] + nums[right];
               if(sum == 0){
                   result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                   while (left < right && nums[left] == nums[left + 1]) left++;
                   while (left < right && nums[right] == nums[right - 1]) right--;
                   left++;
                   right--;
               }else if (sum < 0){
                   left++;
               }else {
                   right--;
               }
           }
       }
        return result;
    }
}
