package interview150.Graph;

import java.util.*;

public class MinimumGeneticMutation_433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        // 将基因库转换为集合，方便查找
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        // 如果end基因不在基因库中，直接返回-1
        if (!bankSet.contains(endGene)) {
            return -1;
        }

        // 定义所有可能的基因字符
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        // 使用队列进行广度优先搜索（BFS）
        Queue<String> queue = new LinkedList<>();
        // 将起始基因序列加入队列
        queue.add(startGene);
        // 使用集合记录已访问的基因序列，避免重复访问
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        // 初始化变化次数
        int level = 0;

        // 开始BFS
        while (!queue.isEmpty()) {
            // 当前层的节点数量
            int size = queue.size();
            // 遍历当前层的所有节点
            for (int i = 0; i < size; i++) {
                // 取出队列中的一个基因序列
                String current = queue.poll();
                // 如果当前基因序列等于目标基因序列，返回变化次数
                if (current.equals(endGene)) {
                    return level;
                }
                // 将当前基因序列转换为字符数组
                char[] currentArray = current.toCharArray();
                // 尝试改变每个字符
                for (int j = 0; j < currentArray.length; j++) {
                    // 保存当前字符
                    char old = currentArray[j];
                    // 尝试用所有可能的基因字符替换当前字符
                    for (char c : charSet) {
                        currentArray[j] = c;
                        String next = new String(currentArray);
                        // 如果新基因序列在基因库中且未被访问过，将其加入队列
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.add(next);
                        }
                    }
                    // 恢复原来的字符
                    currentArray[j] = old;
                }
            }
            // 增加变化次数
            level++;
        }

        // 如果未找到目标基因序列，返回-1
        return -1;
    }

}
