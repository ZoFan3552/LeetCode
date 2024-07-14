package interview150.Hash;

import java.util.HashMap;

public class WorldPattern_290 {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) return false;
        HashMap<String, Character> characterHashMap = new HashMap<>();
        HashMap<Character, String> stringHashMap = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            Character c = pattern.charAt(i);
            if (stringHashMap.get(c) == null && characterHashMap.get(str) == null){
                stringHashMap.put(c , str);
                characterHashMap.put(str , c);
            }else {
                if (stringHashMap.get(c) == null || characterHashMap.get(str) == null ||
                        !stringHashMap.get(c).equals(str) || characterHashMap.get(str) != c){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new WorldPattern_290().wordPattern("abba" , "dog dog dog dog");
    }
}
