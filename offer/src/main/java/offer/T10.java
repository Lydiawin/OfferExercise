package offer;

/*
* offer.T10：二进制中1的个数
* 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
* */
public class T10 {
    public class Solution {
        /*
            一条规则：记住！
            把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于是把这个整数的二进制表示中的最右边的1变成0
            很多二进制的问题都可以使用使用这个思路解决。
            本题：这个整数有多少个1就可以做多少次这样的运算
        */
        public int NumberOf1(int n) {
            int count = 0;
            while (n != 0) {
                n = n & (n - 1);
                count++;
            }
            return count;
        }
    }
    /*=====================数组实现==========================================*/
    public class Solution2 {
        /*
            将输入的数组放到数组中，依次判断是否为1
        */
        public int NumberOf1(int n) {
            int count = 0;
            char[] num = Integer.toBinaryString(n).toCharArray();
            for (int i = 0; i < num.length; i++) {
                if (num[i] == '1')
                    count++;
            }
            return count;
        }
    }
}
