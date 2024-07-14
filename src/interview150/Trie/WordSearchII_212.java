package interview150.Trie;

import java.util.*;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/11 上午10:17
 */
public class WordSearchII_212 {
    // 定义Trie树的节点结构
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];  // 每个节点有26个可能的子节点（对应26个英文字母）
        String word;  // 用来标记在此节点结束的单词，如果非空，则表示从根到此节点的路径形成一个有效单词
    }

    // 主函数，输入字符网格和单词列表，返回网格中找到的单词列表
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();  // 初始化Trie树的根节点
        for (String word : words) {  // 将所有单词添加到Trie树中
            addWord(word, root);
        }

        Set<String> result = new HashSet<>();  // 使用HashSet收集结果，避免重复
        boolean[][] visited = new boolean[board.length][board[0].length];  // 访问标记数组，防止在同一个单词构建过程中重复使用同一单元格

        // 遍历整个板以尝试每个点作为起点
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, visited, result);  // 对每个单元格应用深度优先搜索
            }
        }

        return new ArrayList<>(result);  // 将结果转换为列表形式返回
    }

    // 深度优先搜索函数，用于从board中的(row, col)位置开始，尝试构建单词
    private void dfs(char[][] board, int row, int col, TrieNode node, boolean[][] visited, Set<String> result) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col])
            return;  // 越界或已访问过的单元格直接返回

        char c = board[row][col];
        TrieNode nextNode = node.children[c - 'a'];  // 获取下一个Trie树节点
        if (nextNode == null) return;  // 如果下一个节点为空，说明无法构建单词，返回

        visited[row][col] = true;  // 标记当前单元格为已访问
        if (nextNode.word != null) {  // 检查当前节点是否是一个单词的结束
            result.add(nextNode.word);  // 是则加入到结果集中
        }

        // 递归探索当前单元格的四个方向
        dfs(board, row + 1, col, nextNode, visited, result);
        dfs(board, row - 1, col, nextNode, visited, result);
        dfs(board, row, col + 1, nextNode, visited, result);
        dfs(board, row, col - 1, nextNode, visited, result);

        visited[row][col] = false;  // 回溯，恢复访问状态
    }

    // 将单词添加到Trie树中的辅助函数
    private void addWord(String word, TrieNode root) {
        TrieNode cur = root;  // 从根节点开始
        for (char c : word.toCharArray()) {
            int index = c - 'a';  // 计算字符对应的索引
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();  // 如果路径不存在，创建新节点
            }
            cur = cur.children[index];  // 移动到下一个节点
        }
        cur.word = word;  // 在单词的最后一个字符对应的节点中存储整个单词
    }

}
