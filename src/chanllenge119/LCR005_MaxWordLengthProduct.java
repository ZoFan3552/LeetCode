package chanllenge119;

import java.util.Arrays;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/26 下午3:55
 */
public class LCR005_MaxWordLengthProduct {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        int[] lens = new int[n];

        // 计算每个单词的位掩码表示和长度
        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (int j = 0; j < words[i].length(); j++) {
                mask |= 1 << (words[i].charAt(j) - 'a');
            }
            masks[i] = mask;
            lens[i] = words[i].length();
        }

        int max = 0;
        // 遍历所有不同的单词组合，比较位掩码
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) { // 没有相同字符
                    max = Math.max(max, lens[i] * lens[j]);
                }
            }
        }

        return max;
    }


    public static void main(String[] args) {
        new LCR005_MaxWordLengthProduct().maxProduct(new String[]{"abcw", "baz", "foo", "bar", "fxyz", "abcdef"});
    }
}
