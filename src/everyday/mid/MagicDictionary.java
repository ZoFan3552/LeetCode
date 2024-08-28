package everyday.mid;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/12 下午1:31
 */
public class MagicDictionary {
    private final Set<String> dict;

    public MagicDictionary() {
        dict = new HashSet<>();
    }

    // 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
    public void buildDict(String[] dictionary) {
        Collections.addAll(dict, dictionary);
    }

    // 给定一个字符串 searchWord ，判定能否只将字符串中一个字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配
    public boolean search(String searchWord) {
        for (String word : dict) {
            if (word.length() != searchWord.length()) {
                continue; // 长度不同则直接跳过
            }
            int mismatchCount = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    mismatchCount++;
                    if (mismatchCount > 1) {
                        break; // 超过一个字母不匹配，直接跳出
                    }
                }
            }
            if (mismatchCount == 1) {
                return true; // 发现正好有一个字母不同
            }
        }
        return false;
    }
}
