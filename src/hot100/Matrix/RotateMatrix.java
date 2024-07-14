package hot100.Matrix;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        //行列互换
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix_new[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; ++i) {
            System.arraycopy(matrix_new[i], 0, matrix[i], 0, n);
        }
    }

    public static void main(String[] args) {
        new RotateMatrix().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
