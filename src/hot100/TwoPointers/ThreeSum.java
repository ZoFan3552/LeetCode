package hot100.TwoPointers;

import java.util.*;

/*
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum {
    private final HashSet<String> isExit = new HashSet<>();
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        if (nums.length == 3) {
            int result = nums[0] + nums[1] + nums[2];
            if (result == 0) {
                List<List<Integer>> arrayLists = new ArrayList<>();
                List<Integer> arrayList = new ArrayList<>();
                arrayList.add(nums[0]);
                arrayList.add(nums[1]);
                arrayList.add(nums[2]);
                arrayLists.add(arrayList);
                return arrayLists;
            } else {
                return new ArrayList<>();
            }
        }

        HashSet<Integer> numSet = new HashSet<>();
        int zeroNum = 0;
        for (int num : nums) {
            numSet.add(num);
            if (num == 0){
                zeroNum++;
            }
        }



        if (numSet.size() == 1){
            List<List<Integer>> lists = new ArrayList<>();
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(nums[0]);
            arrayList.add(nums[0]);
            arrayList.add(nums[0]);
            lists.add(arrayList);
            return lists;
        } else if (numSet.size() == 2) {
            return new ArrayList<>();
        } else if (numSet.size() == 3) {
            List<List<Integer>> lists = new ArrayList<>();
            ArrayList<Integer> arrayList = new ArrayList<>();
            int result = 0;
            for (Integer integer : numSet) {
                result += integer;
                arrayList.add(integer);
            }
            lists.add(arrayList);
            if (result == 0){
                if (zeroNum >= 3){
                    ArrayList<Integer> zero = new ArrayList<>();
                    zero.add(0);
                    zero.add(0);
                    zero.add(0);
                    lists.add(zero);
                }
                return lists;
            }else {
                return new ArrayList<>();
            }
        }

        int left = 0;
        int right = left + 1;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (right < nums.length){
                int target = -(nums[left] + nums[right]);
                if (numSet.contains(target)){

                    for (int j = 0; j < nums.length; j++) {
                        if (nums[j] == target && (j != left && j != right)){
                            ArrayList<Integer> arrayList = new ArrayList<>();
                            int[] result = new int[3];
                            result[0] = nums[left];
                            result[1] = nums[right];
                            result[2] = target;
                            if (exit(result)){
                                continue;
                            }
                            arrayList.add(nums[left]);
                            arrayList.add(nums[right]);
                            arrayList.add(target);
                            lists.add(arrayList);
                        }

                    }
                }
                right++;
            }
            left++;
            right = left + 1;
        }
        return lists;
    }

    public boolean exit(int[] result){
        Arrays.sort(result);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : result) {
            stringBuilder.append(i);
        }
        if (isExit.contains(stringBuilder.toString())){
            return true;
        }
        isExit.add(stringBuilder.toString());
        return false;
    }



    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}));
    }
}
