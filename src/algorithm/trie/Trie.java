package algorithm.trie;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/12 下午1:16
 */
public class Trie {
    private final TrieNode root;

    static class TrieNode{
        private final TrieNode[] children;
        private boolean isEnd;

        public TrieNode(){
            children = new TrieNode[26];
            this.isEnd = false;
        }
    }

    public Trie(){
        this.root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word){
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(node.children[index] == null){
                return false;
            }
            node = node.children[index];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix){
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(node.children[index] == null){
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}
