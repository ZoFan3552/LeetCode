package interview150.Range;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null ||  nums.length == 0) return res;
        int start = 0 , end = 0;
        while (end < nums.length){
            if (end == nums.length - 1 || nums[end + 1] != nums[end] + 1){
                StringBuilder stringBuilder = new StringBuilder();
                if (nums[start] == nums[end]){
                    stringBuilder.append(nums[end]);
                }else {
                    stringBuilder.append(nums[start]).append("->").append(nums[end]);
                }
                res.add(stringBuilder.toString());
                start = end + 1;
            }
            end++;
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> res = new SummaryRanges_228().summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        System.out.println(res);
    }
}
