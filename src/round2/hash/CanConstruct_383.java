package round2.hash;

public class CanConstruct_383 {
    /*
        赎金信
        ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
        如果可以，返回 true ；否则返回 false
        1. 因为字母个数有限，直接用字符数组来做字典
        2. 先遍历 magazine，记录字母出现个数
        3. 再遍历 ransomNote，遇到对应字符出现就 -1
        4. 最后遍历字符数组，看是否出现负数
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        // 遍历 magazine
        for (int i = 0; i < magazine.length(); i++)
            map[magazine.charAt(i) - 'a']++;
        // 遍历 ransomNote
        for (int i = 0; i < ransomNote.length(); i++)
            map[ransomNote.charAt(i) - 'a']--;

        // 遍历数组
        for (int i = 0; i < map.length; i++)
            if (map[i] < 0)
                return false;

        return true;
    }
}
