package interview150.BinaryTree;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SameTree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //层序遍历
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();

        pQueue.offer(p);
        qQueue.offer(q);

        while (!pQueue.isEmpty() && !qQueue.isEmpty()){
            while (!pQueue.isEmpty() && !qQueue.isEmpty()){
                TreeNode pNode = pQueue.poll();
                TreeNode qNode = qQueue.poll();
                if ((pNode == null && qNode != null) || (pNode != null && qNode == null)){
                    return false;
                }
                if (pNode != null && qNode != null){
                    if (pNode.val != qNode.val){
                        return false;
                    }
                }
                if (pNode != null){
                    pQueue.offer(pNode.left);
                    pQueue.offer(pNode.right);
                }

                if (qNode != null){
                    qQueue.offer(qNode.left);
                    qQueue.offer(qNode.right);
                }

            }
        }

        return true;
    }



}
