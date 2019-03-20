
/*
* T8: 旋转数组的最小数字
* 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
* 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
* 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
* NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
* */
import java.util.ArrayList;
public class T8 {

    /*
        理解题意：非递减排序：递增或者有元素相同的递增========》二分查找！
        思路：
        1. 两个指针p1和p2，分别指向数组的头和尾；
        2. mid = （p1 + p2）/ 2，若[mid] >= [p1]，p1 = mid,若[mid] <= [p2],p2 = mid；
        3. 当p2 = p1 == 1,则最小的元素就是[p2]，返回即可。
        特殊情况：1）若将0个元素搬到数组的末尾呢？数组是递增的，也就是说第一个元素就是最小的元素，返回！
                2）若数组中有重复元素怎么办呢？只能顺序查找了。
    */
    public class Solution {
        public int minNumberInRotateArray(int [] array) {
            if (array == null || array.length <= 0)
                return 0;
            int p1 = 0;
            int p2 = array.length - 1;
            int mid = 0;
            while(array[p2] <= array[p1]) {
                if (array[p2] - array[p1] == 1) {
                    return array[p2];
                }
                mid = (p1 + p2) / 2;
                if (array[mid] == array[p1] && array[p1] == array[p2]) {
                    return minInOrder(array, p1, p2);
                }
                if (array[mid] >= array[p1]) {
                    p1 = mid;
                } else if (array[mid] <= array[p2]) {
                    p2 = mid;
                }
            }
            return array[mid];
        }
        public int minInOrder(int[] array, int p1, int p2) {
            int result = array[p1];
            for(int i = p1 + 1; i <= p2; i++) {
                if (result > array[i]) {
                    result = array[i];
                }
            }
            return result;
        }
    }
}
