package interview150.Hash;

public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] sHash = new int[26];
        int[] tHash = new int[26];
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        for (int i = 0; i < sCharArray.length; i++) {
            char sChar = sCharArray[i];
            char tChar = tCharArray[i];
            sHash[sChar - 'a']++;
            tHash[tChar - 'a']++;
        }
        for (int i = 0; i < sHash.length; i++) {
            if (sHash[i] != tHash[i]) return false;
        }
        return true;
    }
}
