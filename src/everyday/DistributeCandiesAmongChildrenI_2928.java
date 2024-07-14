package everyday;

public class DistributeCandiesAmongChildrenI_2928 {
    public int distributeCandies(int n, int limit) {
        int res = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                for (int k = 0; k <= limit; k++) {
                    if (i + j + k == n){
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new DistributeCandiesAmongChildrenI_2928().distributeCandies(5, 2);
        System.out.println(res);
    }
}
