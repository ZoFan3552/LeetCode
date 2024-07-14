package interview150.ArrayAndString;

import java.util.HashMap;

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        int minStrLen = Integer.MAX_VALUE;
        String minStr = "";
        for (String str : strs) {
            if (str.length() < minStrLen){
                minStr = str;
                minStrLen = str.length();
            }
        }
        for (int i = 0; i < minStrLen; i++) {
            boolean exit = false;
            for (String str : strs) {
                if (str.charAt(i) != minStr.charAt(i)){
                    exit = true;
                    break;
                }
            }
            if (exit){
                break;
            }
            stringBuilder.append(minStr.charAt(i));
        }
        return stringBuilder.isEmpty() ? "" : stringBuilder.toString();
    }
}
