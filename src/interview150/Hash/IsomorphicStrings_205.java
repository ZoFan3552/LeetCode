package interview150.Hash;

import java.util.HashMap;

public class IsomorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        for (int i = 0; i < sCharArray.length; i++) {
            sMap.putIfAbsent(sCharArray[i] , i);
            tMap.putIfAbsent(tCharArray[i] , i);
            if (!sMap.get(sCharArray[i]).equals( tMap.get(tCharArray[i]))){
                return false;
            }
        }
        return true;
    }
}
