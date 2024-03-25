package round1.hot100.hash;

import java.util.*;

public class GroupAnagrams_49 {
    //    输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    //    输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
    public List<List<String>> groupAnagrams(String[] strs) {
        // 由于互为字母异位词的两个字符串包含的字母相同，
        // 因此对两个字符串分别进行排序之后得到的字符串一定是相同的，
        // 故可以将排序之后的字符串作为哈希表的键
        // key: 排序后的当前字符串  val: 实际字符串
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            // 将当前字符串转化为数组进行排序
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            // 再转回 String 用来做 key
            String key = new String(chars);
            // 用该 key 看 map 中是否有已经有对应 list
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            // 将当前单词加入到该 list 中，然后更新 map
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
