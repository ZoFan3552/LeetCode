package interview150.Hash;

import java.util.HashMap;

public class RansomNote_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        //用数组
        int[] letters = new int[26];
        char[] ransomNoteCharArray = ransomNote.toCharArray();
        char[] magazineCharArray = magazine.toCharArray();
        for (char c : magazineCharArray) {
            letters[c - 'a']++;
        }
        int curStrLen = 0;
        for (char c : ransomNoteCharArray) {
            letters[c - 'a']--;
            if (letters[c - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
