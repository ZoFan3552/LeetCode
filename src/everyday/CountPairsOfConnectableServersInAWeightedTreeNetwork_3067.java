package everyday;

import java.util.*;

/**
 * 给你一棵无根带权树，树中总共有 n 个节点，分别表示 n 个服务器，服务器从 0 到 n - 1 编号。同时给你一个数组 edges ，其中 edges[i] = [ai, bi, weighti] 表示节点 ai 和 bi 之间有一条双向边，边的权值为 weighti 。再给你一个整数 signalSpeed 。
 * <p>
 * 如果两个服务器 a ，b 和 c 满足以下条件，那么我们称服务器 a 和 b 是通过服务器 c 可连接的 ：
 * <p>
 * a < b ，a != c 且 b != c 。
 * 从 c 到 a 的距离是可以被 signalSpeed 整除的。
 * 从 c 到 b 的距离是可以被 signalSpeed 整除的。
 * 从 c 到 b 的路径与从 c 到 a 的路径没有任何公共边。
 * 请你返回一个长度为 n 的整数数组 count ，其中 count[i] 表示通过服务器 i 可连接 的服务器对的 数目 。
 * <p>
 * 输入：edges = [[0,6,3],[6,5,3],[0,3,1],[3,2,7],[3,1,6],[3,4,2]], signalSpeed = 3
 * 输出：[2,0,0,0,0,0,2]
 * 解释：通过服务器 0 ，有 2 个可连接服务器对(4, 5) 和 (4, 6) 。
 * 通过服务器 6 ，有 2 个可连接服务器对 (4, 5) 和 (0, 5) 。
 * 所有服务器对都必须通过服务器 0 或 6 才可连接，所以其他服务器对应的可连接服务器对数目都为 0 。
 */
public class CountPairsOfConnectableServersInAWeightedTreeNetwork_3067 {

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static Map<Integer, List<Edge>> buildTree(int[][] edges) {
        Map<Integer, List<Edge>> tree = new HashMap<>();
        for (int[] edge : edges) {
            tree.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new Edge(edge[1], edge[2]));
            tree.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(new Edge(edge[0], edge[2]));
        }
        return tree;
    }

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        int[] result = new int[n];
        Map<Integer, List<Edge>> tree = buildTree(edges);

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = -1;  // Initialize distances with -1 indicating uncalculated
            }
        }

        for (int i = 0; i < n; i++) {
            dfsDistance(i, -1, 0, dist, tree);
        }

        dfsCountPairs(0, -1, tree, result, dist, signalSpeed);

        return result;
    }

    private static void dfsDistance(int node, int parent, int currentDistance, int[][] dist, Map<Integer, List<Edge>> tree) {
        dist[node][node] = 0;
        for (Edge edge : tree.get(node)) {
            int neighbor = edge.to;
            if (neighbor == parent) {
                continue;
            }
            dist[node][neighbor] = currentDistance + edge.weight;
            dist[neighbor][node] = currentDistance + edge.weight;
            dfsDistance(neighbor, node, currentDistance + edge.weight, dist, tree);
        }
    }

    private static int[] dfsCountPairs(int node, int parent, Map<Integer, List<Edge>> tree, int[] result, int[][] dist, int signalSpeed) {
        int subtreeSize = 1;  // Including the node itself
        int leftCount = 0;  // Number of nodes in the left subtree
        int rightCount = 0;  // Number of nodes in the right subtree

        for (Edge edge : tree.get(node)) {
            int neighbor = edge.to;
            if (neighbor == parent) {
                continue;
            }

            int[] childResult = dfsCountPairs(neighbor, node, tree, result, dist, signalSpeed);
            int childSize = childResult[0];

            if (node < neighbor) {
                leftCount += childSize;
            } else {
                rightCount += childSize;
            }

            subtreeSize += childSize;
        }

        result[node] = leftCount * rightCount;

        return new int[]{subtreeSize, leftCount, rightCount};
    }

}
