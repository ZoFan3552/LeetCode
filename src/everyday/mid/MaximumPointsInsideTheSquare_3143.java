package everyday.mid;

import java.util.*;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/3 上午9:08
 */
public class MaximumPointsInsideTheSquare_3143 {
    public static int maxPointsInsideSquare(int[][] points, String s) {
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.put(points[i], i);
        }
        Arrays.sort(points, (a, b) -> {
            int max1 = Math.max(Math.abs(a[0]) , Math.abs(a[1]));
            int max2 = Math.max(Math.abs(b[0]) , Math.abs(b[1]));
            return Integer.compare(max1, max2);
        });
        LinkedHashMap<Integer , List<int[]>> square = new LinkedHashMap<>();
        for (int[] point : points) {
            int x = point[0], y = point[1];
            int edgeLen = Math.max(Math.abs(x), Math.abs(y)) * 4;
            square.putIfAbsent(edgeLen, new ArrayList<>());
            square.get(edgeLen).add(point);
        }
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (List<int[]> pointList : square.values()) {
            boolean allOut = true;
            for (int[] point : pointList) {
                Integer index = map.get(point);
                char c = s.charAt(index);
                if (set.contains(c)){
                    allOut = false;
                    break;
                }else {
                    set.add(c);
                }
            }
            if (allOut){
                count += pointList.size();
            }else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int res = maxPointsInsideSquare(new int[][]{{2, 2}, {-1, -2}, {-4, 4}, {-3, 1}, {3, -3}}, "abdca");
        System.out.println(res);
    }
}
