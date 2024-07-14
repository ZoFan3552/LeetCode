package hot100.BinaryTree;

import java.util.*;

public class RightSideView {
    /*
    递归版本 DFS
    List<Integer> result =new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {

     DFS(root,1);
     return result;

    }
    public void DFS(TreeNode node ,int depth){
        if(node == null)return;
        if(depth > result.size()){
            result.add(node.val);
        }
        else{
            result.set(depth - 1,node.val);
        }
        DFS(node.left,depth+1);
        DFS(node.right,depth+1);

    }
     */
    //层序遍历 BFS版本
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //层序遍历
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        res.add(root.val);
        while (!nodes.isEmpty()) {
            Deque<TreeNode> tempNodes = new LinkedList<>();
            while (!nodes.isEmpty()) {
                TreeNode node = nodes.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    tempNodes.add(left);
                }
                if (right != null) {
                    tempNodes.add(right);
                }
            }
            if (!tempNodes.isEmpty()) {
                res.add(tempNodes.getLast().val);
            }
            nodes.addAll(tempNodes);
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.right = new TreeNode(3);
//        treeNode.right.left = new TreeNode(3);
//        treeNode.right.right = new TreeNode(6);
        List<Integer> integers = new RightSideView().rightSideView(treeNode);
        System.out.println(integers);
    }
}
