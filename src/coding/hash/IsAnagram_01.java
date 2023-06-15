package coding.hash;

public class IsAnagram_01 {
    /*
        数据规模可控 -> 数组，规模过大 -> set k-v -> map
        开 26 大小数组，分别遍历两个字符串，分别在数组对应位置加和减
        最后遍历记录的数组，有位置不为 0 则两个字符串字母组成不同
        时间复杂度: O(n + m)
        空间复杂度: O(1)
     */
    public boolean isAnagram(String s, String t) {
        int[] res = new int[26];

        for (int i = 0; i < s.length(); i++)
            res[s.charAt(i) - 'a']++;

        for (int i = 0; i < t.length(); i++)
            res[t.charAt(i) - 'a']--;
        // 数组如果有元素不为 0 代表两个字符串的字母组成不同
        for (int i = 0; i < res.length; i++)
            if (res[i] != 0)
                return false;

        return true;
    }
}
