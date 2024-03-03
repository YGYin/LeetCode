package round1.hash;

public class IsAnagram_242 {
    public boolean isAnagram(String s, String t) {
        // 用数组记录出现字母次数
        int[] record = new int[26];
        // 分别遍历两个字符串
        for (int i = 0; i < s.length(); i++)
            record[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++)
            record[t.charAt(i) - 'a']--;
        // 遍历数组如果出现不为 0，说明两个字符串字母出现次数不一样
        for (int i = 0; i < record.length; i++)
            if (record[i] != 0)
                return false;
        return true;
    }
}
