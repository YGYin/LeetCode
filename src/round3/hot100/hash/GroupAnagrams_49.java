package round3.hot100.hash;

import java.util.*;

public class GroupAnagrams_49 {
    /*
        字母异位词分组
        将 排序后的 str 作为 key，val 为 list 储存异位词
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        // List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 转数组，排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            // 看 map 中有没有，没有就新建
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            // val 中的 list 添加 str，再 put 回去更新
            list.add(str);
            map.put(key, list);
        }
        // 可以使用 map.values 替代新建 res 变量
        return new ArrayList<>(map.values());
    }
}
