package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
* T23 层序遍历二叉树/广度优先遍历二叉树
* 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
*
* 容器：队列；
* 1. 根节点入队；
* 2. 取出队头元素，将其左右子结点入队，直到叶子节点
* 3. 打印队列元素直到队列为空
* */
public class T23 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            if (root == null) {
                return new ArrayList<Integer>();
            }
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            ArrayList<Integer> arr = new ArrayList<Integer>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                arr.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            return arr;
        }
    }
}
