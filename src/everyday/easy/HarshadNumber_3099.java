package everyday.easy;

public class HarshadNumber_3099 {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int allBitSum = getAllBitSum(x);
        if (x % allBitSum == 0) {
            return allBitSum;
        }
        return -1;
    }

    public int getAllBitSum(int n) {
        int sum = 0;
        while (n != 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
