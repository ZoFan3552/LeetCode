package interview150.TwoPointers;

import java.util.Arrays;

public class TwoSumII_InputArrayIsSorted_167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int p1 = 0 , p2 = numbers.length - 1;
        while (p1 < p2){
            if (numbers[p1] + numbers[p2] == target){
                res[0] = p1 + 1;
                res[1] = p2 + 1;
                return res;
            }else if (numbers[p1] + numbers[p2] > target){
                p2--;
            }else {
                p1++;
            }
        }
        return res;
    }
}
