package hot100.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        char[] charArray = s.toCharArray();
        int[] charsLastIndex = new int[26];
        for (int i = 0; i < charArray.length; i++) {
            charsLastIndex[charArray[i] - 'a'] = i;
        }
        int len = 0;
        int start = 0;
        int maxIndex = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < charArray.length; i++) {
            int lastIndex = charsLastIndex[charArray[i] - 'a'];
            len = Math.max(len, lastIndex - start + 1);
            maxIndex = Math.max(maxIndex , lastIndex);
            if (i == maxIndex) {
                result.add(len);
                len = 0;
                start = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> res = new PartitionLabels().partitionLabels("caedbdedda");
        System.out.println(res);
    }
}
