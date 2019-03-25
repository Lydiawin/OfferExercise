package offer;

import java.util.ArrayList;
import java.util.Stack;
/*
*  offer.T5: 从尾到头打印链表
*  题目：
*  输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
*  输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。（牛客）
* */
public class T5 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        /*
        1. 从尾到头打印：栈
        2. 首先要有一个栈；
        3. 遍历链表，将链表的值存入栈中；
        4. 从栈顶依次取出元素，放到ArrayList中
        */
            //1. 栈实现
            //遇到的问题：
            // 1. 弄明白各个数据架构需要加载的包；
            // 2. 明白各个数据结构想要存储的类型，看好返回类型时什么；
            // 3. 判空操作，什么时候使用null，什么是时候使用isEmpty。
            Stack<ListNode> stack = new Stack<ListNode>();
            while (listNode != null) {
                stack.push(listNode);
                listNode =listNode.next;
            }
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            while (!stack.isEmpty()) {
                arrayList.add(stack.pop().val);
            }
            return arrayList;
        }
    }
    /*=====================================递归实现====================================================*/
    public class Solution2 {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        /*
        从尾到头的意思是：遇到一个结点，先将它后边的结点打印出来，在输出这个结点====》递归
        递归在本质上就是一个栈结构
        */
            if (listNode != null) {
                printListFromTailToHead(listNode.next);
                arrayList.add(listNode.val);

            }
            return arrayList;
        }
    }
}
