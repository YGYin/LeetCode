package offer;

public class ReplaceSpace_05 {
    public String replaceSpace(String s) {
        if (s == null)
            return null;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == ' ')
                stringBuilder.append("%20");
            else
                stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public String replaceSpace_2(String s) {
        return s.replace(" ", "%20");
    }
}
