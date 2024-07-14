package interview150.TwoPointers;

public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int left = 0 , right = charArray.length - 1;
        while (left <= right){
            if (notLetterOrDigit(charArray[left])){
                left++;
                continue;
            }
            if (notLetterOrDigit(charArray[right])){
                right--;
                continue;
            }
            if (Character.toLowerCase(charArray[left]) != Character.toLowerCase(charArray[right])){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean notLetterOrDigit(char c){
        return (c < 'a' || c > 'z') &&
                (c < 'A' || c > 'Z') &&
                (c < '0' || c > '9');
    }
}
