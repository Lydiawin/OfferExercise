package LeetCode;

import java.util.Arrays;

/*
* T242 有效的字母易位词
* 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
示例 1:
输入: s = "anagram", t = "nagaram"
输出: true

示例 2:
输入: s = "rat", t = "car"
输出: false

说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
* */


/*
* 若输入的字符包含unicode字符，可以使用哈希表来实现计数存储的效果
* */
public class ValidAnagram242 {
    /*
    * 将字符串转换成数组，进行排序，若排序后的两个字符数组不同，则说明false，否则为true
    * */
    public class Solution1 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length())
                return false;
            char[] str1 = s.toCharArray();
            char[] str2 = t.toCharArray();
            Arrays.sort(str1);
            Arrays.sort(str2);
            return Arrays.equals(str1, str2);
        }
    }
        /*构造一个26字母长度的数组，s中遇到一个元素，在相应位置上加一
          遇到t的元素减一，最后遍历数组，若含有不为0的元素，则为false
        */
    public class Solution2 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length())
                return false;
            int[] counter = new int[26];
            for (int i = 0; i < s.length(); ++i) {
                counter[s.charAt(i) - 'a']++;
                counter[t.charAt(i) - 'a']--;
            }
            for (int count : counter) {
                if (count != 0)
                    return false;
            }
            return true;
        }
    }
        /*构造一个26字母长度的数组，s中遇到一个元素，在相应位置上加一
          遇到t的元素减一，最后遍历数组，若含有不为0的元素，则为false
          在处理t的时候可以直接查看count值是否<0,若<0则说明false
        */
    public class Solution3 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length())
                return false;
            int[] counter = new int[26];
            for (int i = 0; i < s.length(); ++i) {
                counter[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < t.length(); ++i) {
                counter[t.charAt(i) - 'a']--;
                if (counter[t.charAt(i) - 'a'] < 0)
                    return false;
            }
            return true;
        }
    }
}
