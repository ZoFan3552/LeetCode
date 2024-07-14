package interview150.Hash;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicateII_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i] , i);
            if (map.containsKey(nums[i]) && i != map.get(nums[i])){
                if (Math.abs(i - map.get(nums[i])) <= k) return true;
                map.put(nums[i] , i);
            }
        }
        return false;
    }
}
