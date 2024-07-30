package everyday.mid;

import java.util.Arrays;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/27 上午11:31
 */
public class LexicographicallySmallestStringAfterOperationsWithConstraint_3106 {
    public static String getSmallestString(String s, int k) {
        if (k == 0 || s == null || s.isEmpty()) return s;
        char[] charArray = s.toCharArray();
        int totalDistance = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (totalDistance == k) break;
            char oldChar = charArray[i];
            for (int j = 0; j < 26; j++) {
                char newChar = (char) ('a' + j);
                int distance = distance(newChar, oldChar);
                if (distance >= 0 && totalDistance + distance <= k){
                    totalDistance += distance;
                    charArray[i] = newChar;
                    break;
                }
            }
        }
        return String.valueOf(charArray);
    }

    public static int distance(char c1, char c2){
        int distanceLeft = c2 - c1;
        int distanceRight = (c1 - 'a') + ('z' - c2) + 1;
        return Math.min(distanceLeft, distanceRight);
    }

    public static void main(String[] args) {
        String res = getSmallestString("xaxcd", 4);
        System.out.println(res);
        System.out.println(distance('a' , 'z'));
    }
}
