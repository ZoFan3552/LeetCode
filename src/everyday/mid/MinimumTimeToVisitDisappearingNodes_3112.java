package everyday.mid;

import java.util.*;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/18 上午10:35
 */
public class MinimumTimeToVisitDisappearingNodes_3112 {


    public int[] minimumTime(int numNodes, int[][] edges, int[] disappearTimes) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        //初始化图
        for (int[] edge : edges) {
            int source = edge[0];
            int destination = edge[1];
            int weight = edge[2];
            if (!graph.containsKey(edge[0])) {
                graph.put(source, new ArrayList<>());
            }
            graph.get(source).add(new int[]{destination, weight});
        }

        //Dijkstra算法中的距离数组
        int[] shortestTimes = new int[numNodes];
        Arrays.fill(shortestTimes, Integer.MAX_VALUE);
        shortestTimes[0] = 0;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        priorityQueue.offer(new int[]{0, 0});
        boolean[] visited = new boolean[numNodes]; // 判断是否已经访问过了，减少不必要的操作

        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int currentNode = current[0];
            int currentTime = current[1];

            if (visited[currentNode]) continue; // 访问过的就跳过
            if (currentTime > disappearTimes[currentNode]) continue; // 不能到达这个节点
            visited[currentNode] = true;

            for (int[] adjacent : graph.getOrDefault(currentNode, Collections.emptyList())) {
                int adjacentNode = adjacent[0];
                int travelTime = adjacent[1];
                int newTime = currentTime + travelTime;

                if (newTime < shortestTimes[adjacentNode] && newTime < disappearTimes[adjacentNode]) {
                    shortestTimes[adjacentNode] = newTime;
                    priorityQueue.offer(new int[]{adjacentNode, newTime});
                }
            }
        }

        for (int i = 0; i < numNodes; i++) {
            if (shortestTimes[i] == Integer.MAX_VALUE || shortestTimes[i] >= disappearTimes[i]) {
                shortestTimes[i] = -1;
            }
        }

        return shortestTimes;
    }
}
