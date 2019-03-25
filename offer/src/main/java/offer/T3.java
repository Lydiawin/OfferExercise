package offer;

public class T3 {
    /*
     *题目描述
     *在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     *请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */

    public class Solution {
        public boolean Find(int target, int [][] array) {
        /*
        0. 首先进行边界条件和特殊输入的判断；
        1. 要知道二维数组的行数：row:array.length，列数：col:array[0].length，不要忘记是从0开始计数的
        2. 从数组的最右侧开始判断，相等在返回，不等：target<[][],排除所在列，否则,排除所在行
        3. 如何删除一列：col--,删除一行：row--
        */

            if (array == null || array.length < 1){
                return false;
            }
            int rows = array.length - 1;
            int col = array[0].length - 1;
            int row = 0;
            while (col >= 0 && row <= rows) {
                if (target == array[row][col]) {
                    return true;
                } else if (target < array[row][col]) {
                    col--;
                } else {
                    row++;
                }
            }
            return false;
        }
    }

}
