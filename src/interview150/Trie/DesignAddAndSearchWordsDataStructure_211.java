package interview150.Trie;

public class DesignAddAndSearchWordsDataStructure_211 {
    static class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private final TrieNode root;

    public DesignAddAndSearchWordsDataStructure_211(){
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if (cur.children[index] == null){
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return searchRecursive(word , 0 , root);
    }

    private boolean searchRecursive(String word , int index , TrieNode node) {
        if (index == word.length()){
            return node.isEnd;
        }
        char c = word.charAt(index);
        if (c == '.'){
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && searchRecursive(word , index + 1, node.children[i])){
                    return true;
                }
            }
            return false;
        }else {
            int charIndex = c - 'a';
            if (node.children[charIndex] == null){
                return false;
            }
            return searchRecursive(word , index + 1 , node.children[charIndex]);
        }
    }
}
