package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
* T101 对称二叉树
* 给定一个二叉树，检查它是否是镜像对称的。
* 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

        1
       / \
      2   2
     / \ / \
    3  4 4  3
    但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

        1
       / \
      2   2
       \   \
       3    3
    说明:如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
* */
public class Symmetric_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root, root);
    }
    public boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return (root1.val == root1.val)
                && isMirror(root1.left, root2.right)
                && isMirror(root1.right, root2.left);
    }

    /*=========================迭代==============================================*/
    /*
    * 使用一个队列：队列中两个连续的结点应该是相等的，而且它们的子树互为镜像
    * 最初，队列中是root，root；
    * 每次取出来两个结点比较他们的值；
    * 如果这两个结点的值相等的话，将这两个结点的左右子节点按照相反的顺序插入到队列中；
    * 当队列为空或者检测到树不对称时，算法结束
    * */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}
