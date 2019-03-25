package offer;

public class T15 {
    /*
    * offer.T15 链表中倒数第k个结点
    * 输入一个链表，输出该链表的倒数第k个结点。
    * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾结点是倒数第1个结点。
    * 例如一个链表有6个结点，从头开始它们的值依次是：1、2、3、4、5、6.
    * 这个链表的倒数第3个结点是值为4的结点
    * */

    /*
    链表的问题首先考虑使用指针解决：一个指针不行就两个指针，可以让其中一个指针先走，另一个指针后走
    1. 想要找到链表中倒数第K哥结点：可以使用两个指针：pAhead, pBehind, 开始时都指向头指针；
    2. pAhead先走k-1步，两个指针再一起走，这样，两个指针相差k-1,当pAhead走到链表末尾的时候pBehind正好走到倒数第K哥结点
    考虑代码的鲁棒性：
    1. 输入头结点是否为null；
    2. k是否为0，为0时输出null；
    3. 若链表长度<k怎么办？加一个if判断，当pAhead走k-1步的时候 ，判断下一个结点是否为null，若为null，则说明链表长度<K

    */
    public class ListNode {
        int val;
        ListNode next;
        public void ListNode(int val) {
            this.val = val;
        }
    }
    public class Solution {
        public ListNode FindKthToTail(ListNode head,int k) {
            if (head == null || k == 0) {
                return null;
            }
            ListNode pAhead = head;
            for (int i = 0; i < k - 1; ++i) {
                if (pAhead.next != null) {
                    pAhead = pAhead.next;
                } else {
                    return null;
                }
            }
            ListNode pBehind = head;
            while (pAhead.next != null) {
                pAhead = pAhead.next;
                pBehind = pBehind.next;
            }
            return pBehind;
        }
    }
}
