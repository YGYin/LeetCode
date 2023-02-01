package ds_primer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FirstUniqChar_387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); ++i)
            if (map.get(s.charAt(i)) == 1) return i;

        return -1;
    }

}
