package offer;
/*
* T24 搜索二叉树的后序遍历序列
* 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
* 假设输入的数组的任意两个数字都互不相同。
* */

/*
* 二叉搜索树：left < root < right
* 后序遍历序列：left right root
* 根据数组的最后一个元素，找到左子树和右子树，分别递归处理
* */
public class T24 {
    public static boolean VerifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return VerifySequenceOfBST(sequence, 0, sequence.length - 1);
    }
    public static boolean VerifySequenceOfBST(int[] sequence, int start, int end) {
        if (start >= end)
            return true;
        int index = start;
        while (index < end - 1 && sequence[index] < sequence[end]) {
            index++;
        }
        int right = index;
        while (index < end - 1 && sequence[index] > sequence[end]) {
            index++;
        }
        if (index != end - 1) {
            return false;
        }
        index = right;
        return VerifySequenceOfBST(sequence, start, index - 1) && VerifySequenceOfBST(sequence, index, end - 1);
    }
    public static void main(String[] args){

        //           10
        //         /   \
        //        6     14
        //       /\     /\
        //      4  8  12  16
        int[] data = {4, 8, 6, 12, 16, 14, 10};
        System.out.println("true: " + VerifySequenceOfBST(data));

        //           5
        //          / \
        //         4   7
        //            /
        //           6
        int[] data2 = {4, 6, 7, 5};
        System.out.println("true: " + VerifySequenceOfBST(data2));

        //               5
        //              /
        //             4
        //            /
        //           3
        //          /
        //         2
        //        /
        //       1
        int[] data3 = {1, 2, 3, 4, 5};
        System.out.println("true: " + VerifySequenceOfBST(data3));

        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        //        \
        //         5
        int[] data4 = {5, 4, 3, 2, 1};
        System.out.println("true: " + VerifySequenceOfBST(data4));

        //树只有一个结点
        int[] data5 = {5};
        System.out.println("true: " + VerifySequenceOfBST(data5));

        int[] data6 = {7, 4, 6, 5};
        System.out.println("false: " + VerifySequenceOfBST(data6));

        int[] data7 = {4, 6, 12, 8, 16, 14, 10};
        System.out.println("false: " + VerifySequenceOfBST(data7));
    }
}
