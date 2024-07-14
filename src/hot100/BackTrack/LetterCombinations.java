package hot100.BackTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {
    private static final HashMap<Character, String> letters = new HashMap<>();
    static  {
        letters.put('2', "abc");
        letters.put('3', "def");
        letters.put('4', "ghi");
        letters.put('5', "jkl");
        letters.put('6', "mno");
        letters.put('7', "pqrs");
        letters.put('8', "tuv");
        letters.put('9', "wxyz");
    }
    public List<String> letterCombinations(String digits) {

        int len = digits.length();
        List<String> res = new ArrayList<>();
        if (len == 0) return res;
        backTracking(res,digits,new StringBuilder(),0);
        return res;
    }

    public void backTracking(List<String> list, String digits , StringBuilder stringBuilder , int startIndex) {
        if (startIndex == digits.length()) {
            list.add(new String(stringBuilder));
            return;
        }
        //画出树状图可知，startIndex指的是第几个电话号码对应的字母组，for循环中的i指的是其中的第几个字母
        String str = letters.get(digits.charAt(startIndex));
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(letters.get(digits.charAt(startIndex)).charAt(i));
            backTracking(list, digits, stringBuilder, startIndex+1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new LetterCombinations().letterCombinations("23456789");
        System.out.println(strings);
    }
}
