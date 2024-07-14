package interview150.Graph;

import java.util.*;

public class WordLadder_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 将 wordList 转换为 Set，以便快速查找
        Set<String> wordSet = new HashSet<>(wordList);
        // 如果 endWord 不在 wordSet 中，直接返回 0
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // 初始化双向BFS的两个集合
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>(); // 记录已经访问过的单词
        int count = 1; // 记录转换序列的长度
        beginSet.add(beginWord); // 从 beginWord 开始
        endSet.add(endWord); // 从 endWord 开始

        // 开始双向BFS
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // 总是扩展较小的集合，以优化搜索效率
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            // 用于存储下一层的单词
            Set<String> nextSet = new HashSet<>();
            // 遍历当前层的每一个单词
            for (String word : beginSet) {
                char[] wordArray = word.toCharArray();
                // 尝试改变每个字符
                for (int i = 0; i < wordArray.length; i++) {
                    char oldChar = wordArray[i]; // 保存原始字符
                    // 替换为 'a' 到 'z' 的所有字符
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == oldChar) {
                            continue; // 跳过相同的字符
                        }
                        wordArray[i] = c;
                        String newWord = new String(wordArray);
                        // 如果新单词在 endSet 中，说明找到了路径，返回转换序列长度
                        if (endSet.contains(newWord)) {
                            return count + 1;
                        }
                        // 如果新单词在 wordSet 中且未被访问过，加入下一层
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            nextSet.add(newWord);
                            visited.add(newWord); // 标记为已访问
                        }
                    }
                    wordArray[i] = oldChar; // 恢复原始字符
                }
            }
            // 更新 beginSet 为下一层的单词集合
            beginSet = nextSet;
            count++; // 增加转换序列的长度
        }

        // 如果没有找到转换路径，返回 0
        return 0;
    }
}
