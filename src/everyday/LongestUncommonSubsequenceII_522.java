package everyday;

import hot100.Graph.IslandsNum;

import java.util.*;

public class LongestUncommonSubsequenceII_522 {
    /*
    给定字符串列表 strs ，返回其中 最长的特殊序列 的长度。如果最长特殊序列不存在，返回 -1 。
    特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
     s 的 子序列可以通过删去字符串 s 中的某些字符实现。
    例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
     */
    public int findLUSlength(String[] strs) {
        //先过滤不可能是最长的特殊序列的字符串
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            map .put(str , map.getOrDefault(str , 0) + 1);
        }
        Arrays.sort(strs , (s1 , s2) -> s2.length() - s1.length());
        boolean[] possible = new boolean[strs.length];
        for (int i = 0; i < possible.length; i++) {
            possible[i] = map.get(strs[i]) == 1;
        }
        int p = 0;
        while (p < strs.length){
            while (p < strs.length && !possible[p]){
                p++;
            }
            if (p < strs.length){
                String curLongestStr = strs[p];
                boolean hasFound = true;
                for (int i = p - 1; i >= 0; i--) {
                    if (isSubsequence(curLongestStr , strs[i])){
                        possible[p] = false;
                        hasFound = false;
                        break;
                    }
                }
                if (hasFound){
                    return curLongestStr.length();
                }
            }
        }
        return -1;
    }

    private boolean isSubsequence(String s1, String s2) {
        //判断s1是否是s2的子序列
        int p1 = 0 , p2 = 0;
        while (p1 < s1.length() && p2 < s2.length()){
            if (s1.charAt(p1) == s2.charAt(p2)){
                p1++;
            }
            p2++;
        }
        return p1 == s1.length();
    }

    public static void main(String[] args) {
        int luSlength = new LongestUncommonSubsequenceII_522().findLUSlength(new String[]{"aaa", "aaa", "aa"});
        System.out.println(luSlength);
    }
}
