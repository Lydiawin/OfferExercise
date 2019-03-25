package offer;

public class T4 {
    /*
    * 题目描述
      请实现一个函数，将一个字符串中的每个空格替换成“%20”。
      例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
    * */
    public class Solution {
        public String replaceSpace(StringBuffer str) {
        /*
            问题1：替换字符串，是在原来的字符串上做替换，还是新开辟一个字符串做替换
            问题2：在当前字符串替换，怎么替换才能更有效率（不考虑java的replace方法）。
                  从前往后替换，后面的字符要不断往后移动，要多次移动，所以效率低下。
                  从后往前替换，先计算需要多少空间，然后从后往前移动，则每个字符只会移动一次，这样效率更高
        */
        /*
           不清楚为什么给的是StringBuffer类型的。
           这次学到了StringBuffer的两个方法：
           1. void setLength(int newLength):这是字符序列的长度
           2. void setCharAt(int index, char ch):将给定索引处的字符设置为ch
           3. char charAt(int index)：返回指定索引处的char值

           思路：
            1. 字符串的长度
            2. 多少个空格
            3. 新字符串的长度，包含要替换的空格
            4. 移动和复制
            5. StringBuffer --> String
        */
        /*
            注意：java中一切皆对象，java中的字符串不是以\0结尾，因为对象在生成的时候就已经有自己的状态了，比如长度等。
        */
            int len = str.length();
            if (len <= 0 || str == null) {
                return "";
            }
            int numOfBlank = 0;
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) == ' ') {
                    numOfBlank++;
                }
            }
            int newLen = len + 2 * numOfBlank;
            if (newLen < len) {
                return str.toString();
            }
            int p2 = newLen - 1;
            int p1 = len - 1;
            str.setLength(newLen);
            while (p1 != p2 && p1 >= 0) {
                if (str.charAt(p1) == ' ') {
                    str.setCharAt(p2--, '0');
                    str.setCharAt(p2--, '2');
                    str.setCharAt(p2--, '%');
                }else {
                    str.setCharAt(p2--, str.charAt(p1));
                }
                p1--;
            }
            return str.toString();
        }
    }
}
