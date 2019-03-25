package offer;

import java.util.Stack;
/*
* offer.T7:两个栈实现队列
* 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
* */
public class T7 {

    /*
        1. 队列是先进先出，栈是先进后出
        2. stack1用于入队，stact2用于出队
        3. 入队时，直接push到stack1中，出队时，若stack2有值，直接pop，若stack2无值，将stack1中的元素全部出栈并push到stack2中

    */
    public class Solution {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.isEmpty()) {
                throw new RuntimeException("No more element!");
            }
            return stack2.pop();
        }
    }
}
