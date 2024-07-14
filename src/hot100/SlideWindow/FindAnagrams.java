package hot100.SlideWindow;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()){
            return new ArrayList<>();
        }
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();

        int[] pChars = new int[26];
        int[] sChars = new int[26];

        for(int i = 0; i < m; i++){//统计条件字符串中每个字符出现的次数
            pChars[p.charAt(i) - 'a'] ++;
        }

        int left = 0;//左区间从0开始
        for(int right = 0; right < n; right++){
            int curRight = s.charAt(right) - 'a';
            sChars[curRight]++;
            while(sChars[curRight] > pChars[curRight]){
                int curLeft = s.charAt(left) - 'a';
                sChars[curLeft]--;
                left++;
            }
            if(right - left + 1 == m){
                res.add(left);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        List<Integer> anagrams = new FindAnagrams().findAnagrams("bababcd" , "abc");
        System.out.println(anagrams);
    }
}
