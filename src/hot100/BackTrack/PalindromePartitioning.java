package hot100.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    private final List<List<String>> result = new ArrayList<>();
    private final List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTracking(s , 0);
        return result;
    }

    public void backTracking(String s , int startIndex){
        if (startIndex == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex ; i < s.length() ; i++){
            if (checkPalindrome(s, startIndex, i)){
                path.add(s.substring(startIndex, i+1));
            }else {
                continue;
            }
            backTracking(s , i + 1);
            path.remove(path.size() - 1);
        }
    }


    public boolean checkPalindrome(String s , int start , int end) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> partition = new PalindromePartitioning().partition("aab");
        System.out.println(partition);
    }
}
