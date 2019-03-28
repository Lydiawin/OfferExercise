package offer;

import java.util.Stack;

/*
* 输入两个整数序列，第一个序列表示栈的压入顺序，判断第二个序列是否为该栈的弹出序列
* 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压栈序列，序列4,5,3,2,1是
* 该压栈序列对应的一个弹出序列，但是4,3,5,1,2就不可能是该压栈序列的弹出序列
* */
public class T22 {
    public class Solution {
        public boolean IsPopOrder(int[] pushOrder, int[] popOrder) {
            if (pushOrder == null || popOrder == null || pushOrder.length == 0 || popOrder.length == 0 || pushOrder.length != popOrder.length) {
                return false;
            }
            Stack<Integer> stack = new Stack<Integer>();
            int pushIndex = 0;
            int popIndex = 0;
            while (popIndex < popOrder.length) {
                while (pushIndex < pushOrder.length && (stack.isEmpty() || popOrder[popIndex] != stack.peek())) {
                    stack.push(pushOrder[pushIndex++]);
                }
                if (stack.peek() == popOrder[popIndex]) {
                    stack.pop();
                    popIndex++;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

}
