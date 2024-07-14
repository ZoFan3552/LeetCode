package everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class FindLongestSpecialSubstringThatOccursThriceII_2982 {
    public int maximumLength(String s) {
        /*
        dp[i]为以s[i]为结尾的最长特殊子字符串长度
        如果s[i-1] = s[i]，则dp[i]= dp[i-1] + 1
         */
        int res = -1;
        char[] charArray = s.toCharArray();
        ArrayList<PriorityQueue<Integer>> queues = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            queues.add(new PriorityQueue<>());
        }
        int[] dp = new int[charArray.length];
        dp[0] = 1;
        queues.get(charArray[0] - 'a').add(dp[0]);
        for (int i = 1; i < charArray.length; i++) {
            if(charArray[i] == charArray[i-1]){
                dp[i] = dp[i-1] + 1;
            }else {
                dp[i] = 1;
            }
            int index = charArray[i] - 'a';
            PriorityQueue<Integer> queue = queues.get(index);
            if(queue.size() >=3 ){
                if (queue.peek() < dp[i]){
                    queue.poll();
                    queue.add(dp[i]);
                }
            }else {
                queue.add(dp[i]);
            }
        }
        for (PriorityQueue<Integer> queue : queues) {
            if (queue.size() == 3){
                res = Math.max(res, queue.peek());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new FindLongestSpecialSubstringThatOccursThriceII_2982().maximumLength("ccc");
        System.out.println(res);
    }
}
