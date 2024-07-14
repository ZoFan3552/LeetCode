package everyday.mid;

public class MaximumPrimeDifference_3115 {
    public int maximumPrimeDifference(int[] nums) {
        int left = 0, right = nums.length - 1;
        boolean foundFirst = false, foundLast = false;
        while (left < right) {
            if (foundFirst && foundLast) {
                break;
            }
            if (!foundFirst) {
                if (isPrime(nums[left])) {
                    foundFirst = true;
                }else {
                    left++;
                }

            }
            if (!foundLast) {
                if (isPrime(nums[right])) {
                    foundLast = true;
                }else {
                    right--;
                }

            }
        }
        return right - left;
    }

    public boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int res = new MaximumPrimeDifference_3115().maximumPrimeDifference(new int[]{4,2, 9,5,3});
    }
}
