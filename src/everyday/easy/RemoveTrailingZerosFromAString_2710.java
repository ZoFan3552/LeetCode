package everyday.easy;

public class RemoveTrailingZerosFromAString_2710 {
    public String removeTrailingZeros(String num) {
        int lastZero = num.length() - 1;
        while (num.charAt(lastZero) == '0') {
            lastZero--;
        }
        return num.substring(0, lastZero + 1);
    }
}
