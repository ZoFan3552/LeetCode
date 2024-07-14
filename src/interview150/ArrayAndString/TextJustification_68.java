package interview150.ArrayAndString;

import java.util.ArrayList;
import java.util.List;

public class TextJustification_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int currentWordIndex = 0;

        while (currentWordIndex < words.length) {
            // 确定当前行可以包含的所有单词
            int totalWords = words[currentWordIndex].length();
            int lastWordIndex = currentWordIndex + 1;
            while (lastWordIndex < words.length) {
                if (totalWords + 1 + words[lastWordIndex].length() > maxWidth) break;
                totalWords += 1 + words[lastWordIndex].length();
                lastWordIndex++;
            }

            StringBuilder builder = new StringBuilder();
            int wordsCount = lastWordIndex - currentWordIndex;
            // 特殊处理最后一行
            if (lastWordIndex == words.length || wordsCount == 1) {
                for (int i = currentWordIndex; i < lastWordIndex; i++) {
                    builder.append(words[i]).append(" ");
                }
                builder.deleteCharAt(builder.length() - 1); // 删除多余的空格
                while (builder.length() < maxWidth) {
                    builder.append(" ");
                }
            } else {
                // 计算空格
                int spaces = (maxWidth - totalWords) / (wordsCount - 1);
                int extraSpaces = (maxWidth - totalWords) % (wordsCount - 1);
                for (int i = currentWordIndex; i < lastWordIndex - 1; i++) {
                    builder.append(words[i]);
                    for (int j = 0; j <= spaces + (i - currentWordIndex < extraSpaces ? 1 : 0); j++) {
                        builder.append(" ");
                    }
                }
                builder.append(words[lastWordIndex - 1]); // 添加最后一个单词
            }
            res.add(builder.toString());
            currentWordIndex = lastWordIndex;
        }

        return res;
    }


    public static void main(String[] args) {
        List<String> res = new TextJustification_68().fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20);
        System.out.println(res);
    }
}
