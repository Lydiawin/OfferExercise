package offer;

/*
* 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39
* */
public class T9 {
    public class Solution {
        /*
            循环实现：
        */
        public int Fibonacci(int n) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            int fib1 = 0;
            int fib2 = 1;
            int fibN = 0;
            for (int i = 2; i <= n; ++i) {
                fibN = fib1 + fib2;
                fib1 = fib2;
                fib2 = fibN;
            }
            return fibN;
        }
    }
    /*========================递归实现=======================================*/
    public class Solution2 {
        /*
            递归实现：
            f0 = 0; f1 = 1; fn = fn-1 + fn-2;
        */
        public int Fibonacci(int n) {
            if (n == 0) return 0;
            if (n == 1) return 1;
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }
}
