package interview150.Graph;

import javax.swing.*;
import java.util.*;

public class SnakesAndLadders_909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1]; // 标记每个格子是否访问过
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0}); // {当前编号, 移动次数}
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currPos = curr[0]; // 当前格子编号
            int moves = curr[1];   // 当前移动次数

            // 尝试投掷骰子，范围为 1 到 6
            for (int i = 1; i <= 6; i++) {
                int nextPos = currPos + i; // 下一个格子编号
                if (nextPos > n * n) break; // 如果超过最大编号，退出循环

                // 获取下一个格子的二维坐标
                int[] nextCoords = getCoordinates(nextPos, n);
                int r = nextCoords[0], c = nextCoords[1];

                // 如果下一个格子有梯子或蛇，更新目标位置
                if (board[r][c] != -1) {
                    nextPos = board[r][c];
                }

                // 如果到达终点，返回总的移动次数
                if (nextPos == n * n) {
                    return moves + 1;
                }

                // 如果下一个格子还没有被访问过，将其加入队列
                if (!visited[nextPos]) {
                    visited[nextPos] = true;
                    queue.offer(new int[]{nextPos, moves + 1});
                }
            }
        }

        // 如果无法到达终点，返回 -1
        return -1;
    }

    // 将一维编号转换为二维坐标
    private int[] getCoordinates(int pos, int n) {
        int row = (pos - 1) / n;   // 计算行号
        int col = (pos - 1) % n;   // 计算列号
        if (row % 2 == 0) {
            // 偶数行，从左到右
            return new int[]{n - 1 - row, col};
        } else {
            // 奇数行，从右到左
            return new int[]{n - 1 - row, n - 1 - col};
        }
    }

}
