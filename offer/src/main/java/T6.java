/*
* T6：重建二叉树
* 题目：
* 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
* 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
* 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
* */
public class T6 {
/*
    1. 首先判断输入是否合理：前序，中序序列长度是否一致，不能为null；
    2. 找到根节点的位置，确定左子树和右子树的长度；
    3. 递归地处理左子树，递归地处理右子树；
    4. 新建一棵树，返回处理后的结果。
*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
            if (pre == null || in == null || pre.length != in.length) {
                return null;
            }
            return reConstruct(pre, 0, pre.length - 1, in, 0, in.length - 1);
        }
        public TreeNode reConstruct(int[] pre, int ps, int pe, int[] in, int is, int ie) {
            if (ps > pe || is > ie)
                return null;
            int data = pre[ps];
            int index = is;
            while (index <= ie && in[index] != data) {
                index++;
            }
            TreeNode tree = new TreeNode(data);
            tree.left = reConstruct(pre, ps + 1, ps + index - is, in, is, index - 1);
            tree.right = reConstruct(pre, ps + index - is + 1, pe, in, index + 1, ie);
            return tree;
        }
    }
}
