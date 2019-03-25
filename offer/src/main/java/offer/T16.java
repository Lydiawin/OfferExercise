package offer;

public class T16 {
    /*
    * offer.T16 反转链表
    * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点
    * */
    public class ListNode {
        int val;
        ListNode next;
        public void ListNode(int val) {
            this.val = val;
        }
    }
/*
    需要保证处理结点的过程中，链表不断裂：三个指针：pPre, pNode, pNext,循环处理结点
    反转链表的头结点就是原链表的尾结点；pNode.nexy == null
    考虑特殊的情况：
    1. 输入链表为空
    2. 输入链表只有一个结点
*/
    public class Solution {
        public ListNode ReverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pPre = null;
            ListNode pNode = head;
            while (pNode != null) {
                ListNode pNext = pNode.next;
                pNode.next = pPre;
                pPre = pNode;
                pNode = pNext;
            }
            return pPre;
        }
    }

    /*====================================递归实现===========================================*/
    /*
    递归实现:保证不出现环，找到递归的出口
    */
    public class Solution2 {
        public ListNode ReverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pReverseHead = ReverseList(head.next);
            head.next.next = head;
            head.next = null;
            return pReverseHead;
        }
    }
}
