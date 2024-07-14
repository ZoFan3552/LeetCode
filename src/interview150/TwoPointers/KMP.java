package interview150.TwoPointers;

public class KMP {
    public boolean isSubStr(String s, String t) {
        int[] prefix = getPrefix(s);
        char[] pattern = s.toCharArray();
        char[] text = t.toCharArray();
        int i = 0 , j = 0;
        while (i < text.length) {
            while (j > 0 && text[i] != pattern[j]){//如果不匹配，那么就从前缀表中找到起始位置，避免重复匹配
                j = prefix[j - 1];
            }
            if (text[i] == pattern[j]){
                if (j == pattern.length - 1){
                    //j = prefix[j];
                    return true;
                }else {
                    j++;
                }
            }
            i++;
        }
        return false;
    }

    public int[] getPrefix(String pattern){
        char[] patternCharArray = pattern.toCharArray();
        int[] prefix = new int[patternCharArray.length];
        prefix[0] = 0;
        int j = 0;
        for (int i = 1; i < patternCharArray.length; i++) {
            while (j > 0 && patternCharArray[i] != patternCharArray[j]){
                j = prefix[j - 1];
            }
            if (patternCharArray[i] == patternCharArray[j]){
                j++;
            }
            prefix[i] = j;
        }
        return prefix;
    }
}
