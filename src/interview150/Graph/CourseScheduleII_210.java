package interview150.Graph;

import java.util.*;

public class CourseScheduleII_210 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }
        // 初始化入度数组和邻接表
        int[] inDegree = new int[numCourses];
        List<Integer>[] adjList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 填充入度数组和邻接表
        for (int[] prerequisite : prerequisites) {
            int dest = prerequisite[0];
            int src = prerequisite[1];
            adjList[src].add(dest);
            inDegree[dest]++;
        }

        // 初始化队列，加入所有入度为0的课程
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] res = new int[numCourses];
        int index = 0;

        // 处理队列中的课程
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[index++] = course;

            // 遍历当前课程的邻接课程，减少其入度
            for (int neighbor : adjList[course]) {
                inDegree[neighbor]--;
                // 如果邻接课程的入度变为0，加入队列
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // 如果不能完成所有课程，返回空数组
        if (index != numCourses) {
            return new int[0];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] order = findOrder(3, new int[][]{{1, 0},{1,2},{0,1}});
        System.out.println(Arrays.toString(order));
    }
}
