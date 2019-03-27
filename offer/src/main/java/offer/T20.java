package offer;

import java.lang.reflect.Array;
import java.util.ArrayList;

/*
* T20 顺时针打印矩阵
* 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
* 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
* 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
*
* 思路：
* 循环打印矩阵的一圈，每次打印一圈的时候按照：开始的坐标(start, start)
* 循环的条件是：行数>start*2 && 列数>start*2
* 1. 从左到右打印一行  最后一圈肯定存在一行
* 2. 从上到下打印一列  最后一圈最少两行
* 3. 从右到左打印一行  最后一圈最少有两行两列
* 4. 从下到上打印一列  最后一圈至少有三行两列
* */
public class T20 {
    public class Solution {
        public ArrayList<Integer> printMatrix(int[][] matrix) {
            int rows = matrix.length;
            int columns = matrix[0].length;
            if (matrix == null || rows <= 0 || columns <= 0) {
                return null;
            }
            int start = 0;
            ArrayList<Integer> result = new ArrayList<Integer>();
            while (rows > start * 2 && columns > start * 2) {
                printMatrixInCircle(matrix, rows, columns, start, result);
                ++start;
            }
            return result;
        }
        public void printMatrixInCircle(int[][] matrix, int rows, int columns, int start, ArrayList<Integer> result) {
            int endX = columns - 1 - start;
            int endY = rows - 1 - start;
            //从左到右打印一行
            for (int i = start; i <= endX; ++i) {
                int num = matrix[start][i];
                result.add(num);
            }
            //从上到下打印一列
            if (start < endY) {
                for (int i = start + 1; i <= endY; ++i) {
                    int num = matrix[i][endX];
                    result.add(num);
                }
            }
            //从右到左打印一行
            if (start < endX && start < endY) {
                for (int i = endX - 1; i >= start; --i) {
                    int num = matrix[endY][i];
                    result.add(num);
                }
            }
            //从下到上打印一列
            if (start < endY - 1 && start < endX) {
                for (int i = endY - 1; i >= start + 1; --i) {
                    int num = matrix[i][start];
                    result.add(num);
                }
            }
        }
    }
}
