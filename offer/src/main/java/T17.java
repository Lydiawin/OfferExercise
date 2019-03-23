
/*
* T17:合并两个排序的链表
* 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
* */
public class T17 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    /*===============================递归实现=============================================*/
    /*
        注意判断条件，保证不会出现空指针引用的问题；
        当一个链表是空链表，则它的头指针是空指针，则将排序的链表和第二个链表合并；
        同理，如果第二个链表是空链表，将其和第一个链表合并
    */
    public class Solution {
        public ListNode Merge(ListNode list1,ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            ListNode pMergedHead = null;
            if (list1.val < list2.val) {
                pMergedHead = list1;
                pMergedHead.next = Merge(list1.next, list2);
            } else {
                pMergedHead = list2;
                pMergedHead.next = Merge(list1, list2.next);
            }
            return pMergedHead;
        }
    }
    /*==============================循环实现==================================================*/
    public class Solution2 {
        public ListNode Merge(ListNode list1,ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;
            ListNode pMergedHead = new ListNode(0);
            ListNode pFlag = pMergedHead;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    pFlag.next = list1;
                    list1 = list1.next;
                } else {
                    pFlag.next = list2;
                    list2 = list2.next;
                }
                // 注意每次做完赋值操作后都要移动到下一个节点处，想不明白就画图
                pFlag = pFlag.next;
            }
            if (list1 == null) pFlag.next = list2;
            if (list2 == null) pFlag.next = list1;
            return pMergedHead.next;
        }
    }
}
