
/*
* 矩形覆盖
* 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
* 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
* */
public class T9_4 {
    public static class Solution {
        /*
                    f1 = 1;
                    f2 = 2;
                    fn = fn-1 + fn-2;
                    2. 循环实现
                */
        public int RectCover(int target) {
            if (target == 1) return 1;
            if (target == 2) return 2;
            int rec1 = 1;
            int rec2 = 2;
            int recN = 0;
            for (int i = 3; i <= target; ++i) {
                recN = rec1 + rec2;
                rec1 = rec2;
                rec2 = recN;
            }
            return recN;
        }
    }
    /*=============================递归实现========================================*/
    public static class Solution2 {
        /*
            f1 = 1;
            f2 = 2;
            fn = fn-1 + fn-2;
            1. 递归实现
        */
        public int RectCover(int target) {
            if (target == 1) return 1;
            if (target == 2) return 2;
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.RectCover(8));
        Solution solution = new Solution();
        System.out.println(solution.RectCover(8));
    }
}
