package hot100.SlideWindow;

import java.util.HashMap;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> temp = new HashMap<>();
        while (right < chars.length){
            if (temp.containsKey(chars[right])){
                int dupIndex = temp.get(chars[right]);
                for (int i = left; i < dupIndex; i++) {
                    temp.remove(chars[i]);
                }
                maxLength = Math.max(maxLength , right - left);
                temp.put(chars[right] , right);
                left = dupIndex + 1;
                right++;
                continue;
            }
            temp.put(chars[right] , right);
            right++;
        }
        maxLength = Math.max(maxLength , right - left);
        return maxLength;
    }

    public static void main(String[] args) {

        int i = new LongestSubstring().lengthOfLongestSubstring("dvdf");
        System.out.println(i);
    }
}