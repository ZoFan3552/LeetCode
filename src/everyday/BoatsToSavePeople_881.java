package everyday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class BoatsToSavePeople_881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0 , right = people.length - 1;
        int res = 0;
        while (people[right] == limit){
            res++;
            right--;
        }
        while (left <= right){
            if (left == right){
                res++;
                break;
            }
            res++;
            if (people[right] + people[left] <= limit){
                left++;
            }
            right--;
        }
        return res;
    }
}
