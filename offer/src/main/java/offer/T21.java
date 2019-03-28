package offer;
/*
 * 定义栈的数据结构，在该类型中实现一个能够得到的最小的元素的min函数
 * 在该栈中，调用pop、push、以及min的时间复杂度都是O(1)
 * */

import java.util.Stack;

/*
* 使用辅助栈，存的是每次压栈的最小元素
* 辅助栈的栈顶存的始终是最小的元素值
* */
public class T21 {
    public class Solution {
        Stack<Integer> stack = new Stack();
        Stack<Integer> minStack = new Stack();

        public void push(int node) {
            stack.push(node);
            if (minStack.isEmpty() || node < minStack.peek()) {
                minStack.push(node);
            } else {
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            if (!stack.isEmpty() && !minStack.isEmpty()){
                stack.pop();
                minStack.pop();
            }
        }

        public int top() {
            if (stack.isEmpty()){
                throw new RuntimeException("No element in stack.");
            }
            return stack.peek();
        }

        public int min() {
            if (minStack.isEmpty()){
                throw new RuntimeException("No element in stack.");
            }
            return minStack.peek();
        }
    }
}
