package algorithm.union;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/4 下午4:04
 */
public class NumberOfProvinces_547 {
    static class UnionFind {
        private final int[] parent;
        private final int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        UnionFind unionFind = new UnionFind(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (unionFind.find(i) == i) {//自己就是祖先
                count++;
            }
        }
        return count;
    }
}
