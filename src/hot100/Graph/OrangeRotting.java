package hot100.Graph;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class OrangeRotting {
    public int orangesRotting(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;//新鲜橘子的数量
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});//将烂橘子入队
                }
            }
        }

        int minutes = 0;
        while (freshCount > 0 && !queue.isEmpty()) {//对队列中的烂橘子进行判断
            minutes++;//每轮代表分钟数加一
            int length = queue.size();//本轮查询的长度
            for (int i = 0; i < length; i++) {
                int[] rottenOrange = queue.poll();
                int row = rottenOrange[0];
                int col = rottenOrange[1];

                //对烂橘子周围进行判断，若有新鲜橘子，则污染，并将其加入队列用于下一轮查询
                if(row - 1 >= 0 && grid[row-1][col] == 1) {
                    grid[row-1][col] = 2;
                    freshCount--;
                    queue.add(new int[]{row-1, col});
                }

                if(row + 1 < rowLen && grid[row+1][col] == 1) {
                    grid[row+1][col] = 2;
                    freshCount--;
                    queue.add(new int[]{row+1, col});
                }

                if(col - 1 >= 0 && grid[row][col-1] == 1) {
                    grid[row][col-1] = 2;
                    freshCount--;
                    queue.add(new int[]{row, col-1});
                }

                if(col + 1 < colLen && grid[row][col+1] == 1) {
                    grid[row][col+1] = 2;
                    freshCount--;
                    queue.add(new int[]{row, col+1});
                }
            }
        }
        //若最后都还有新鲜橘子，则说明存在不能被污染的橘子，返回-1
        return freshCount > 0 ? -1 : minutes;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        OrangeRotting orangeRotting = new OrangeRotting();
        orangeRotting.orangesRotting(grid);
    }
}
