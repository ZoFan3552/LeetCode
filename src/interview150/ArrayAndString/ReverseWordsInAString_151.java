package interview150.ArrayAndString;

import java.util.ArrayList;
import java.util.LinkedList;

public class ReverseWordsInAString_151 {
    public String reverseWords(String s) {
        String[] strings = s.split(" +");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            stringBuilder.append(strings[i]).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        String string = new ReverseWordsInAString_151().reverseWords("a good   example");
        System.out.println(string);
    }
}
