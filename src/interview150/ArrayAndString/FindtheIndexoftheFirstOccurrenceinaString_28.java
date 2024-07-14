package interview150.ArrayAndString;

public class FindtheIndexoftheFirstOccurrenceinaString_28 {
    public int strStr(String haystack, String needle) {
        int p1 = 0 , p2 = 0;
        char[] haystackCharArray = haystack.toCharArray();
        char[] needleCharArray = needle.toCharArray();
        while (p1 < haystackCharArray.length && p2 < needleCharArray.length){
            int matchLen = 0;
            while (p1 < haystackCharArray.length
                    && haystackCharArray[p1] != needleCharArray[p2]){
                p1++;
            }
            int firstStart = p1;
            while ((p1 < haystackCharArray.length && p2 < needleCharArray.length)
                    && haystackCharArray[p1] == needleCharArray[p2]){
                p1++;
                p2++;
                matchLen++;
            }
            if (matchLen == needleCharArray.length){
                return firstStart;
            }
            p1 = firstStart + 1;
            p2 = 0;
        }
        return -1;
    }
}
