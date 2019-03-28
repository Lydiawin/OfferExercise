package offer;
/*
* 相关题目：
* 判断数组是不是某二叉搜索树的前序遍历序列
* */
public class T24_2 {
    public boolean VerifySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return VerifySequenceOfBST(sequence, 0, sequence.length - 1);
    }

    private boolean VerifySequenceOfBST(int[] sequence, int start, int end) {
        if (start >= end)
            return true;
        int index = start + 1;
        while (index <= end && sequence[index] < sequence[start]) {
            index++;
        }
        int right = index;
        while (index <= end && sequence[index] > sequence[start]) {
            index++;
        }
        if (index != end + 1) {
            return false;
        }
        index = right;
        return VerifySequenceOfBST(sequence, start + 1, index - 1) && VerifySequenceOfBST(sequence, index, end);
    }
}
