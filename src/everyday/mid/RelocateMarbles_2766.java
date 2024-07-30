package everyday.mid;

import java.util.*;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/24 上午10:54
 */
public class RelocateMarbles_2766 {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> stones = new HashSet<>();
        for (int num : nums) {
            stones.add(num);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            int from = moveFrom[i];
            int to = moveTo[i];
            stones.remove(from);
            stones.add(to);
        }
        List<Integer> result = new ArrayList<>(stones);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> res = new RelocateMarbles_2766().relocateMarbles(new int[]{3, 4}, new int[]{4, 3, 1, 2, 2, 3, 2, 4, 1}
                , new int[]{3, 1, 2, 2, 3, 2, 4, 1, 1});

    }
}
