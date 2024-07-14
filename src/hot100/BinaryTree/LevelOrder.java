package hot100.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(root.val);
        res.add(arrayList);
        while (!nodes.isEmpty()){
            Queue<TreeNode> tempNodes = new LinkedList<>();
            ArrayList<Integer> tempVals = new ArrayList<>();
            while (!nodes.isEmpty()){
                TreeNode node = nodes.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null){
                    tempVals.add(left.val);
                    tempNodes.add(left);
                }
                if (right != null){
                    tempVals.add(right.val);
                    tempNodes.add(right);
                }
            }
            if (!tempVals.isEmpty()){
                res.add(tempVals);
            }
            nodes.addAll(tempNodes);
        }
        return res;
    }
}
