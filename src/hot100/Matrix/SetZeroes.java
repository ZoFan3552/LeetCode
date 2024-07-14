package hot100.Matrix;

import java.util.HashSet;

/*
给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        //可将hash换成boolean数组，再倒叙遍历矩阵进行判断
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> columns = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0){
                    columns.add(j);
                    rows.add(i);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows.contains(i) || columns.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        new SetZeroes().setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }
}
