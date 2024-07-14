package everyday.easy;

public class NumberOfBeautifulPairs_2748 {
    public int countBeautifulPairs(int[] nums) {
        int pairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int first = nums[i] , last = nums[j];
                while (first >= 10){
                    first /= 10;
                }
                last %= 10;
                if (gcd(first , last) == 1){
                    pairs++;
                }
            }
        }
        return pairs;
    }

    public int gcd(int a , int b){
        while (b != 0){
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}
