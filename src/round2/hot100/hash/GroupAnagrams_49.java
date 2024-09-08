package round2.hot100.hash;

import java.util.*;

public class GroupAnagrams_49 {
    /*
        字母异位词分组
        由于互为字母异位词的两个字符串包含的字母相同，
        因此对两个字符串分别进行排序之后得到的字符串一定是相同的，
        故可以将排序之后的字符串作为哈希表的键
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        // 用 map 储存字母异位词，key: 排序后的字符串  value: 储存字母异位词的 list
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // 将字符串存到 char 数组中方便排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            // 再转会字符串作为 map 的 key
            String key = new String(chars);
            // 如果存在 key 就取出 list 来更新字母异位词，没有就新建 list
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        // 返回 value
        return new ArrayList<List<String>>(map.values());
    }
}
