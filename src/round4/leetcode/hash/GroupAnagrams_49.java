package round4.leetcode.hash;

import java.util.*;

public class GroupAnagrams_49 {
    /*
        字母异位词分组
        本质就是将同样字母个数的单词放在同一个 list 里
        建一个 map<String, List<String>>, key 为排序后的字符串，val 为原字符串
        遍历字符串，通过转为字符串数组进行排序，然后看 map 中是否存在决定是否更新 list
        最后返回 map.values()
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();

        // key 为排序后的字符串，val 为原字符串
        Map<String, List<String>> map = new HashMap<>();
        // 遍历字符串
        for (String str : strs) {
            // 转字符串 排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            // 将原字符串加入 list，更新 map
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
