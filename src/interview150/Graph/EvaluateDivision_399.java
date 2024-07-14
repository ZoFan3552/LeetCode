package interview150.Graph;

import java.util.*;

public class EvaluateDivision_399 {
    // 图的表示，使用嵌套的哈希表，其中 graph.get(A).get(B) = A / B
    private final Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 构建图
        buildGraph(equations, values);

        // 存储查询结果
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);

            // 如果图中不包含起点或终点，则结果为 -1.0
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                results[i] = -1.0;
            } else {
                // 使用集合记录已访问的节点，避免循环
                Set<String> visited = new HashSet<>();
                // 使用 DFS 搜索路径并计算结果
                results[i] = dfs(start, end, 1.0, visited);
            }
        }
        return results;
    }

    private void buildGraph(List<List<String>> equations, double[] values) {
        // 遍历每个等式和对应的值
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String A = equation.get(0);
            String B = equation.get(1);
            double value = values[i];

            // 如果图中不包含节点 A 或 B，则初始化它们的邻接表
            graph.putIfAbsent(A, new HashMap<>());
            graph.putIfAbsent(B, new HashMap<>());

            // 设置 A/B = value 和 B/A = 1.0/value
            graph.get(A).put(B, value);
            graph.get(B).put(A, 1.0 / value);
        }
    }

    private double dfs(String start, String end, double value, Set<String> visited) {
        // 如果起点等于终点，返回当前累积的值
        if (start.equals(end)) return value;

        // 将当前节点标记为已访问
        visited.add(start);

        // 遍历当前节点的所有邻居节点
        Map<String, Double> neighbors = graph.get(start);
        for (String neighbor : neighbors.keySet()) {
            // 如果邻居节点未被访问
            if (!visited.contains(neighbor)) {
                // 继续进行 DFS 搜索，并更新累积值
                double result = dfs(neighbor, end, value * neighbors.get(neighbor), visited);
                // 如果找到有效结果，返回结果
                if (result != -1.0) return result;
            }
        }
        // 如果未找到路径，返回 -1.0
        return -1.0;
    }
}
