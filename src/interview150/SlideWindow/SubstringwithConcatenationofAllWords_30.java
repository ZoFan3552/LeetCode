package interview150.SlideWindow;

import java.util.*;

public class SubstringwithConcatenationofAllWords_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.isEmpty() || s.length() < words[0].length() * words.length) return  res;
        Map<String , Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word , wordCount.getOrDefault(word , 0) + 1);
        }
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;

        // 外层循环，变量i控制检查的起始位置，每次移动一个单词长度
        //通过对单词长度取余得到的起点不同，这样就可以减少大量重复的判断
        //比如wordLen = 4 ，那么当 i = 0时，分割得到的单词和 i = 4时是一样的
        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> currentCount = new HashMap<>();
            // 内层循环，从起始位置开始，每次跳过一个单词长度
            for (int j = i; j <= s.length() - wordLen; j += wordLen) {
                String word = s.substring(j, j + wordLen);
                // 如果单词在words中，处理单词频率和窗口移动
                if (wordCount.containsKey(word)) {
                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
                    count++;

                    // 如果当前单词的数量超过了需要的数量，移动左边界直到单词数量合理
                    while (currentCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // 如果窗口内单词数量等于words数组的长度，记录起始索引
                    if (count == words.length) {
                        res.add(left);
                        String leftWord = s.substring(left, left + wordLen);
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                } else {
                    // 如果遇到不在words中的单词，重置所有参数，从j+wordLength位置开始新的检查
                    currentCount.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SubstringwithConcatenationofAllWords_30 substringwithConcatenationofAllWords30 = new SubstringwithConcatenationofAllWords_30();
        List<Integer> res = substringwithConcatenationofAllWords30.findSubstring("", new String[]{"ab","ba","ba"});
        System.out.println(res);
    }
}
