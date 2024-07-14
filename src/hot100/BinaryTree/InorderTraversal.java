package hot100.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    List<Integer> vals = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return vals;
        }
        inorderTraversal(root.left);
        vals.add(root.val);
        inorderTraversal(root.right);
        return vals;
    }

/*
迭代法实现
public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
 */

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 5;
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(6);
        List<Integer> integers = new InorderTraversal().inorderTraversal(treeNode);
        System.out.println(integers);
    }
}
