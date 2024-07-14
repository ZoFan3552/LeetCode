package interview150.TwoPointers;

import java.awt.*;
import java.sql.SQLOutput;

public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        if (s.equals(t)) return true;
        char[] subsequence = s.toCharArray();
        char[] text = t.toCharArray();
        int p1 = 0 , p2 = 0;
        int subLen = 0;
        while (p1 < subsequence.length && p2 < text.length){
            if (subsequence[p1] == text[p2]){
                subLen++;
                p1++;
            }
            p2++;
        }
        return subLen == subsequence.length;
    }

    public static void main(String[] args) {
        boolean subsequence = new IsSubsequence_392().isSubsequence("axc", "ahbgdc");
    }
}
