package hot100.BinaryTree;


import java.util.List;

public class FlattenTreeToList {
    //不使用额外空间
    private TreeNode pre = null;
    //利用后续遍历来防止右孩子节点丢失
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 5;
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(6);
        new FlattenTreeToList().flatten(treeNode);
    }
}
