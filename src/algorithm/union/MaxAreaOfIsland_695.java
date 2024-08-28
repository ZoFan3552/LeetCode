package algorithm.union;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/24 下午7:30
 */
public class MaxAreaOfIsland_695 {
    static class UnionFind {
        private final int[] parent;
        private final int[] size;  // 记录每个集合的大小

        public UnionFind(int totalSize) {
            parent = new int[totalSize];
            size = new int[totalSize];
            for (int i = 0; i < totalSize; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);  // 路径压缩
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootY] = rootX;  // 合并到rootX
                size[rootX] += size[rootY];  // 更新rootX的大小
            }
        }

        public int getSize(int x) {
            int rootX = find(x);
            return size[rootX];
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);

        // 四个方向，右、下、左、上
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // 遍历整个矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int current = i * n + j;  // 当前节点在并查集中的索引
                    for (int[] direction : directions) {
                        int newX = i + direction[0];
                        int newY = j + direction[1];
                        // 检查相邻节点是否在范围内且为1
                        if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                            int neighbor = newX * n + newY;
                            uf.union(current, neighbor);  // 合并两个节点
                        }
                    }
                }
            }
        }

        int maxArea = 0;
        // 再次遍历，找出最大的岛屿面积
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int current = i * n + j;
                    maxArea = Math.max(maxArea, uf.getSize(current));  // 计算最大面积
                }
            }
        }

        return maxArea;
    }
}
