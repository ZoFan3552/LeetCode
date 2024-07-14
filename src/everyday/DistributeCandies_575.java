package everyday;

import java.util.HashSet;

public class DistributeCandies_575 {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        int eatableCandies = n / 2;
        HashSet<Integer> candies = new HashSet<>();
        for (int j : candyType) {
            candies.add(j);
        }
        return Math.min(candies.size(), eatableCandies);
    }
}
