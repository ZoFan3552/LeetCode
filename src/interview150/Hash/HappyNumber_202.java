package interview150.Hash;

import java.util.HashSet;

public class HappyNumber_202 {
    public boolean isHappy(int n) {
        int[] square = new int[10];
        for (int i = 0; i < 10; i++) {
            square[i]  = i * i;
        }
        HashSet<Integer> set = new HashSet<>();
        String num = String.valueOf(n);
        int initial = 0;
        for (int i = 0; i < num.length(); i++) {
            initial += square[num.charAt(i) - '0'];
        }
        set.add(initial);
        int temp = initial;
        while (true){
            String newNum = String.valueOf(temp);
            int squareSum = 0;
            for (int i = 0; i < newNum.length(); i++) {
                squareSum += square[newNum.charAt(i) - '0'];
            }
            if (squareSum == 1) return true;

            if (set.contains(squareSum)) break;
            set.add(squareSum);
            temp = squareSum;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean happy = new HappyNumber_202().isHappy(19);
    }
}
