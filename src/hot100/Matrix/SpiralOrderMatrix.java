package hot100.Matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int rowLen = matrix[0].length;
        int columnLen = matrix.length;
        int direct = 6;//2,4,6,8 2向下 4向左 6向右 8向上
        int currentRow = 0 , currentColumn = 0;
        while (res.size() != matrix.length * matrix[0].length){
            if (direct == 6){
                while (true){
                    res.add(matrix[currentRow][currentColumn]);
                    visited[currentRow][currentColumn] = true;
                    if (currentColumn + 1 == rowLen || visited[currentRow][currentColumn + 1]){
                        break;
                    }
                    currentColumn++;
                }
                direct = 2;
                currentRow++;
            } else if (direct == 4) {
                while (true){
                    res.add(matrix[currentRow][currentColumn]);
                    visited[currentRow][currentColumn] = true;
                    if (currentColumn - 1 == -1 || visited[currentRow][currentColumn - 1]){
                        break;
                    }
                    currentColumn--;
                }
                direct = 8;
                currentRow--;
            }else if (direct == 2){
                while (true){
                    res.add(matrix[currentRow][currentColumn]);
                    visited[currentRow][currentColumn] = true;
                    if (currentRow + 1 == columnLen || visited[currentRow + 1][currentColumn]){
                        break;
                    }
                    currentRow++;
                }
                direct = 4;
                currentColumn--;
            } else {
                while (true){
                    res.add(matrix[currentRow][currentColumn]);
                    visited[currentRow][currentColumn] = true;
                    if (currentRow - 1 == -1 || visited[currentRow - 1][currentColumn]){
                        break;
                    }
                    currentRow--;
                }
                direct = 6;
                currentColumn++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> res = new SpiralOrderMatrix().spiralOrder(new int[][]{{1, 2, 3,4}, { 5, 6,7,8}, {9,10,11,12}});
        System.out.println(res);
    }
}
