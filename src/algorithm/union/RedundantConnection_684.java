package algorithm.union;

import java.util.Arrays;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/4 下午4:46
 */
public class RedundantConnection_684 {
    static class UnionFind {
        private final int[] parent;  // 记录每个节点的父节点
        private final int[] rank;    // 记录每个节点的秩（用于平衡树的高度）

        public UnionFind(int size) {
            // 初始化Union-Find的结构，节点值从1到size，因此需要size + 1的空间
            parent = new int[size + 1];
            rank = new int[size + 1];
            // 初始化，每个节点的父节点指向自身，初始秩为0
            for (int i = 1; i <= size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            // 路径压缩：递归地查找父节点，并将当前节点的父节点指向根节点
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];  // 返回根节点
        }

        public boolean union(int x, int y) {
            // 查找x和y的根节点
            int rootX = find(x);
            int rootY = find(y);
            // 如果x和y的根节点不同，进行合并
            if (rootX != rootY) {
                // 将秩较低的树合并到秩较高的树上，保持树的平衡
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;  // rootY的父节点变为rootX
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;  // rootX的父节点变为rootY
                } else {
                    parent[rootY] = rootX;  // 如果秩相同，任选其一并增加其秩
                    rank[rootX]++;
                }
                return true;  // 返回true表示成功合并
            }
            // 如果x和y已经在同一个集合中，说明该边是冗余的
            return false;
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int size = edges.length;  // 边的数量
        UnionFind unionFind = new UnionFind(size);  // 初始化Union-Find
        int[] parent = new int[size + 1];  // 记录每个节点的父节点
        Arrays.fill(parent, -1);  // 将父节点数组初始化为-1（表示还没有父节点）
        int[] first = null;  // 记录第一个冲突的边（如果有两个父节点的情况）
        int[] second = null;  // 记录第二个冲突的边（如果有两个父节点的情况）
        int[] conflict = null;  // 记录导致冲突的边

        // 第一次遍历所有边，检查是否有节点有两个父节点
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (parent[v] == -1) {
                parent[v] = u;  // 如果v还没有父节点，记录u为其父节点
            } else {
                // 如果v已经有父节点，说明发生了冲突
                conflict = edge;  // 记录冲突边
                first = new int[]{parent[v], v};  // 记录第一个父节点对应的边
                second = edge;  // 记录第二个父节点对应的边
                break;  // 结束遍历，进入下一阶段
            }
        }

        // 第二次遍历所有边，使用Union-Find检查是否有环
        unionFind = new UnionFind(size);  // 重置Union-Find以重新检查
        for (int[] edge : edges) {
            if (edge == conflict) continue;  // 跳过冲突边
            if (!unionFind.union(edge[0], edge[1])) {
                // 如果出现了环，判断是否存在冲突边
                if (conflict != null) return first;  // 如果有冲突边，返回第一个父节点对应的边
                return edge;  // 否则返回当前导致环的边
            }
        }

        // 如果没有出现环且有冲突边，返回第二个父节点对应的边
        return second;
    }

}
