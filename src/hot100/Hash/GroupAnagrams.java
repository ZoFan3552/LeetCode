package hot100.Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public String getAsciiSum(String str){
        char[] charsArray = str.toCharArray();
        Arrays.sort(charsArray);
        return Arrays.toString(charsArray);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String ,List<String>> ascii = new HashMap<>();
        for(String str : strs){
            String sum = getAsciiSum(str);
            if(ascii.containsKey(sum)){
                ascii.get(sum).add(str);
            }else{
                ArrayList<String> strings = new ArrayList<>();
                strings.add(str);
                ascii.put(sum , strings);
            }
        }
        return new ArrayList<>(ascii.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> lists = groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}
