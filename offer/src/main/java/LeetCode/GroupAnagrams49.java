package LeetCode;
/*
* 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：
所有输入均为小写字母。
不考虑答案输出的顺序。
* */

import java.util.*;

public class GroupAnagrams49 {
    /*
    * 将字符数组中的每一个字符串排序，当且仅当它们的排序字符串相等时，两个字符串才是字母异位词。
    * 维护一个String---List的map，将排序字符串作为key，若为异位词，则将其放到同一个key下
    *
    * 时间复杂度：O(NK \log K)O(NKlogK)，其中 NN 是 strs 的长度，
    * 而 KK 是 strs 中字符串的最大长度。当
    * 我们遍历每个字符串时，外部循环具有的复杂度为 O(N)O(N)。然后，我们在 O(K \log K)O(KlogK) 的时间内对每个字符串排序。
    *
    * 空间复杂度：O(NK)O(NK)，排序存储在 ans 中的全部信息内容。
    * */
    public class Solution1 {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0)
                return null;
            Map<String, List> ans = new HashMap<String, List>();
            for (String s : strs) {
                char[] ch = s.toCharArray();
                Arrays.sort(ch);
                String key = String.valueOf(ch);
                if (!ans.containsKey(key)) {
                    ans.put(key, new ArrayList());
                }
                ans.get(key).add(s);
            }
            return new ArrayList(ans.values());
        }
    }
    class Solution {
        /*
          当且仅当它们的字符计数（每个字符的出现次数）相同时，两个字符串是字母异位词。
          我们可以将每个字符串 \text{s}s 转换为字符数 \text{count}count，由26个非负整数组成，表示 \text{a}a，\text{b}b，\text{c}c 的数量等。我们使用这些计数作为哈希映射的基础。

          在 Java 中，我们的字符数 count 的散列化表示将是一个用 **＃** 字符分隔的字符串。 例如，abbccc 将表示为 ＃1＃2＃3＃0＃0＃0 ...＃0，其中总共有26个条目。
        */
        /*
        * 当每个字符串中字母出现的次数相同时，两个字符串是异位词。
        * 将每个字符串中字母出现的次数转换为key值，构造map：String, List进行维护
        * */
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0)
                return null;
            Map<String, List> ans = new HashMap<String, List>();
            int[] count = new int[26];
            for (String s : strs) {
                Arrays.fill(count, 0);
                for (char c : s.toCharArray()) {
                    count[c - 'a']++;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 26; ++i) {
                    sb.append(count[i]);
                }
                String key = sb.toString();
                if (!ans.containsKey(key)) {
                    ans.put(key, new ArrayList());
                }
                ans.get(key).add(s);
            }
            return new ArrayList(ans.values());
        }
    }
}
