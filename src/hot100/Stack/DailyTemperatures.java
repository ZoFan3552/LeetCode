package hot100.Stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>() ;
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (temperatures[i] > temperatures[stack.peek()]) {
                    while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                        res[stack.peek()] = i - stack.peek();
                        stack.pop();
                    }
                    stack.push(i);
                } else {
                    stack.push(i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] dailyTemperatures = new DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(dailyTemperatures));
    }
}
