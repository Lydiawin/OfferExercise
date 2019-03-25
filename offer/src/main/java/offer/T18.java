package offer;

import java.util.Stack;

/*
* T18 二叉树的镜像
* 操作给定的二叉树，将其变换为源二叉树的镜像。
* */
public class T18 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        public void Mirror(TreeNode root) {
            if (root == null) return;
            if (root.left == null && root.right == null) return;
            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;
            if (root.left != null) {
                Mirror(root.left);
            }
            if (root.right != null) {
                Mirror(root.right);
            }
        }
    }
    /*==========================非递归方式：栈===============================*/
    /*
    * 递归=======栈
    * */
    public class Solution2 {
        public void Mirror2(TreeNode root) {
            if (root == null || (root.left == null && root.right == null))
                return;
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.left != null || node.right != null) {
                    swap(node);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        public void swap(TreeNode node) {
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }
}
