package everyday;

import java.util.HashSet;

public class LongestUncommonSubsequenceI_521 {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        return Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        int res = new LongestUncommonSubsequenceI_521().findLUSlength("aaa", "bbb");
        System.out.println(res);
    }
}
