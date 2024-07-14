package hot100.SubString;

/*
76.最小覆盖子串
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

注意：

对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。
 */
/*
1.找到包含所有t中的所有字符串的窗口，且窗口大小不能小于t的长度
2.如果当前窗口一个字符都没找到，立马跳跃一个窗口大小(优化)
3.如果当前窗口在滑动到s的末尾都没找到包含t的子串，则将窗口增大，继续从头开始滑动，直到窗口大小为s的长度
4.若最后都没找到，返回空
5.否则返回符合的窗口，退出循环
 */
public class MinWindow {
    // 定义一个方法找到字符串s中包含字符串t所有字符的最小子串
    public String minWindow(String s, String t) {
        // 获取字符串s和t的长度
        int sLen = s.length();
        int tLen = t.length();
        // 将字符串s和t转换成字符数组
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        // 定义两个数组记录字符出现的次数，ASCII表大小为128
        int[] window = new int[128];
        int[] need = new int[128];
        // 初始化need数组，记录字符串t中每个字符需要的次数
        for (char c : tChars) {
            need[c]++;
        }
        // diff变量用来记录当前窗口中还差多少个t中的字符
        int diff = tLen;
        // 定义双指针，分别表示窗口的左右边界
        int left = 0, right = 0;
        // start记录最小覆盖子串开始的位置，minSubStrLen记录最小覆盖子串的长度
        int start = 0, minSubStrLen = sLen + 1;
        // 右指针r开始滑动
        while (right < sLen) {
            // 如果当前字符是t中的字符，且窗口中该字符的数量不足，则diff减一
            if (window[sChars[right]] < need[sChars[right]]) {
                diff--;
            }
            // 窗口中包含右指针指向的字符的数量加一
            window[sChars[right]]++;
            // 当diff为0时，说明窗口已经包含了t中所有的字符
            while (diff == 0) {
                // 如果当前窗口大小小于之前的最小长度，则更新最小长度和起始位置
                if (right - left + 1 < minSubStrLen) {
                    minSubStrLen = right - left + 1;
                    start = left;
                }
                // 如果左指针指向的字符是t中的字符，且数量刚好满足需要，则diff加一
                if (window[sChars[left]] == need[sChars[left]]) {
                    diff++;
                }
                // 窗口中包含左指针指向的字符的数量减一
                window[sChars[left]]--;
                // 左指针向右移动，缩小窗口
                left++;
            }
            // 右指针向右移动，扩大窗口
            right++;
        }
        // 如果minSubStrLen没有被更新过，返回空字符串，否则返回最小覆盖子串
        return minSubStrLen == sLen + 1 ? "" : s.substring(start, start + minSubStrLen);
    }

    public static void main(String[] args) {
        String s = new MinWindow().minWindow("bba", "ba");
        System.out.println(s);
    }
}

