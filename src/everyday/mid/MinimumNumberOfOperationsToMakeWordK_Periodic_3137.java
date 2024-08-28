package everyday.mid;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/17 下午10:22
 */
public class MinimumNumberOfOperationsToMakeWordK_Periodic_3137 {
    public static int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> frequency = new HashMap<>();
        int n = word.length();

        // 统计每个子串的频率
        for (int i = 0; i < n; i += k) {
            String sub = word.substring(i, Math.min(i + k, n)); // 确保不会越界
            frequency.put(sub, frequency.getOrDefault(sub, 0) + 1);
        }

        // 找到出现频率最高的子串
        int maxFrequency = 0;
        for (int count : frequency.values()) {
            if (count > maxFrequency) {
                maxFrequency = count;
            }
        }

        // 需要替换的子串数量是总子串数量减去最大频率的子串数量
        return (n / k) - maxFrequency;
    }

    public static void main(String[] args) {
        int res = minimumOperationsToMakeKPeriodic("leetcodeleet", 4);
    }
}
