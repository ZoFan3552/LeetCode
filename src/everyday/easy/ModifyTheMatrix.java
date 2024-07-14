package everyday.easy;

import java.util.ArrayList;
import java.util.List;

public class ModifyTheMatrix {
    public int[][] modifiedMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            int max = Integer.MIN_VALUE;
            List<Integer> toModify = new ArrayList<>();
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == -1){
                    toModify.add(j);
                }else {
                    max = Math.max(max, matrix[j][i]);
                }
            }
            for (Integer index : toModify) {
                matrix[index][i] = max;
            }
        }
        return matrix;
    }
}
