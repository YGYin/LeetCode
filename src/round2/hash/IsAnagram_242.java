package round2.hash;

public class IsAnagram_242 {
    /*
        有效的字母异位词
        因为两个字符串，只出现 26 个字母，用数组做哈希表
        遍历 s，出现的话对应位置 + 1，遍历 t 出现字符对应字符 - 1
        如果最后哈希表有位置不为 0 的话，则为 false
     */
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;

        for (int i = 0; i < t.length(); i++)
            count[t.charAt(i) - 'a']--;

        for (int i = 0; i < count.length; i++)
            if (count[i] != 0)
                return false;

        return true;
    }
}
