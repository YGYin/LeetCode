package round1.hash;

public class CanConstruct_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        // 因为每个字符只能使用一次，如果 note 长度比 magazine 大则 false
        if (ransomNote.length() > magazine.length())
            return false;
        // 记录 26 个字符出现次数，元素个数较少 -> 数组
        int[] record = new int[26];
        // 先遍历 magazine
        for (int i = 0; i < magazine.length(); i++)
            record[magazine.charAt(i) - 'a']++;
        // 再遍历 Note
        for (int i = 0; i < ransomNote.length(); i++)
            record[ransomNote.charAt(i) - 'a']--;

        // 遍历 record，如果 note 能由 magazine 里的字符组成
        // record 里所有元素剩余次数应该 >= 0
        for (int i = 0; i < record.length; i++)
            if (record[i] < 0)
                return false;

        return true;
    }
}
