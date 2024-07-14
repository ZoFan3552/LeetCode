package interview150.ArrayAndString;

import java.util.Arrays;

public class H_Index_274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int h = n - i; // 计算当前的h，即至少有h篇论文
            if (citations[i] >= h) {
                return h; // 找到最大的h
            }
        }
        return 0; // 如果没有找到满足条件的h，返回0
    }
}
