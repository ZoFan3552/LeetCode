package interview150.BinaryTree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class LowestCommonAncestorOfABinaryTree_236 {
    private int pHeight = 0;
    private int qHeight = 0;
    private final Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) return root;
        helper(root , p , q , 0);
        if (pHeight < qHeight){
            TreeNode node = q;
            for (int i = 0; i < qHeight - pHeight; i++) {
                node = parentMap.get(node);
                System.out.println("parent:" + node.val);
            }
            if (node == p) return p;
            return getParent(p , node);
        }else if (pHeight > qHeight){
            TreeNode node = p;
            for (int i = 0; i < pHeight - qHeight; i++) {
                node = parentMap.get(node);
                System.out.println("parent:" + node.val);
            }
            if (node == q) return q;
            return getParent(node , q);
        }
        return getParent(p , q);
    }

    public void helper(TreeNode root, TreeNode p, TreeNode q , int curHeight){
        if (root == null) return;
        if (root == p) {
            pHeight = curHeight;
        }
        if (root == q) {
            qHeight = curHeight;
        }
        if (root.left != null) parentMap.put(root.left, root);
        if (root.right != null) parentMap.put(root.right, root);
        helper(root.left , p, q , curHeight + 1);
        helper(root.right , p, q , curHeight + 1);
    }

    public TreeNode getParent(TreeNode p, TreeNode q){
        while (true){
            p = parentMap.get(p);
            q = parentMap.get(q);
            if (p == q) return p;
        }
    }
}
