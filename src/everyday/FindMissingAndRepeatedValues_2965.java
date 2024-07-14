package everyday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FindMissingAndRepeatedValues_2965 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int nSquare = n * n;
        int missing = 0;
        int repeat = 0;
        HashSet<Integer> set = new HashSet<>(nSquare);
        for (int i = 1; i <= nSquare; i++) {
            set.add(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean remove = set.remove(grid[i][j]);
                if (!remove){
                    repeat = grid[i][j];
                }
            }
        }
        for (Integer i : set) {
            missing = i;
        }
        int[] res = new int[2];
        res[0] = repeat;
        res[1] = missing;
        return res;
    }

    public static void main(String[] args) {
        FindMissingAndRepeatedValues_2965 findMissingAndRepeatedValues2965 = new FindMissingAndRepeatedValues_2965();
        int[] res = findMissingAndRepeatedValues2965.findMissingAndRepeatedValues(new int[][]{{9,1,7},{8,9,2},{3,4,6}});
        System.out.println(Arrays.toString(res));
    }
}
