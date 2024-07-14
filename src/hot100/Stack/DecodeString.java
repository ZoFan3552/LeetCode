package hot100.Stack;

import java.util.LinkedList;
import java.util.Stack;

public class DecodeString {


    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int repeatTimes = 0;
        LinkedList<Integer> timesStack = new LinkedList<>();
        LinkedList<String> resStack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                timesStack.addLast(repeatTimes);
                resStack.add(res.toString());
                repeatTimes = 0;
                res = new StringBuilder();
            }else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                int curRepeatTimes = timesStack.removeLast();
                temp.append(String.valueOf(res).repeat(Math.max(0, curRepeatTimes)));
                res = new StringBuilder(resStack.removeLast() + temp);
            }else if (Character.isDigit(c)) {
                repeatTimes = repeatTimes * 10 + Character.getNumericValue(c);
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }
    //递归版本 todo


    public static void main(String[] args) {
        String string = new DecodeString().decodeString("3[a2[c]]");
        System.out.println(string);
    }
}
