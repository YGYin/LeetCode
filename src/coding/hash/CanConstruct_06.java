package coding.hash;

public class CanConstruct_06 {
    /*
        有效的字母异位词 IsAnagram_01 是同一思路
        不同在于上题要求 A B 字符串可以相互组成 -> record != 0 -> false
        该题要求 B 是否能组成 A  -> record[i] < 0 -> false
        -> 体现在遍历 record 数组的判断条件

        时间复杂度: O(n)
        空间复杂度: O(1)

     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];

        for (int i = 0; i < magazine.length(); i++)
            record[magazine.charAt(i) - 'a']++;

        for (int i = 0; i < ransomNote.length(); i++)
            record[ransomNote.charAt(i) - 'a']--;
        // 如果小于零说明 ransomNote 里出现的字符，magazine没有
        for (int i = 0; i < record.length; i++)
            if (record[i] < 0)
                return false;

        return true;
    }
}
