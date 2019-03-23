public class T14 {
    /*
    *T14:调整数组顺序使奇数位于偶数前面
    * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
    * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
    * */
    public class Solution {
        /*
            维护两个指针p1,p2，分别指向数组的头和尾；
            p1只向后移动，p2只向前移动，当p1指向的是偶数，p2指向的是奇数时，交换两个指针所再位置的元素，
            当p2<p1时，说明，所有的奇数已经在偶数前边了。
        */
        public void reOrderArray(int [] array) {
            if (array == null || array.length == 0) {
                return;
            }
            int p1 = 0;
            int p2 = array.length - 1;
            while (p1 < p2) {
                while ((p1 < p2) && (array[p1] & 0x01) != 0) {
                    p1++;
                }
                while ((p1 < p2) && (array[p2] & 0x01) == 0) {
                    p2--;
                }
                if (p1 < p2) {
                    int temp = 0;
                    temp = array[p1];
                    array[p1] = array[p2];
                    array[p2] = temp;
                }
            }
        }
    }
}
