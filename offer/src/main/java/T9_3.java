
/*
* 变态跳台阶
* 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
* */
public class T9_3 {
    public class Solution {
        /*
            fn = fn-1 + fn-2 + ... + 1;
            fn-1 = fn-2 + fn-3 + ... + 1;
            fn = 2*fn-1;
            2. 循环实现
        */
        public int JumpFloorII(int target) {
            if (target == 1) return 1;
            if (target == 2) return 2;
            int jum2 = 2;
            int jumN = 0;
            for (int i = 3; i <= target; ++i) {
                jumN = 2 * jum2;
                jum2 = jumN;
            }
            return jumN;
        }
    }
    /*===========================递归实现=======================================*/
    public class Solution2 {
        /*
            fn = fn-1 + fn-2 + ... + 1;
            fn-1 = fn-2 + fn-3 + ... + 1;
            fn = 2*fn-1;
        */
        public int JumpFloorII(int target) {
            if (target == 1) return 1;
            if (target == 2) return 2;
            return 2 * JumpFloorII(target - 1);
        }
    }
}
