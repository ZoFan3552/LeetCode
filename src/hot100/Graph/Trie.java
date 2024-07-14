package hot100.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Trie {

    static class TrieNode{
        Map<Character, TrieNode> children;//存放孩子结点
        boolean isEnd;
        public TrieNode(){
            children = new HashMap<>();
        }
    }

    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!current.children.containsKey(c)){
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);//指向下一个结点
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(!current.children.containsKey(c)){//如果找到一个没有的字符，则不存在该字符串
                return false;
            }
            current = current.children.get(c);
        }
        return current.isEnd;//如果走完，还需要看是不是在末尾
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(!current.children.containsKey(c)){//如果找到一个没有的字符，则不存在该字符串的前缀
                return false;
            }
            current = current.children.get(c);
        }
        return true;//如果走完，说明有该前缀
    }
}
