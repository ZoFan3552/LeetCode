package everyday.mid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/22 上午11:32
 */
public class DetonateTheMaximumBombs_2101 {
    Map<Integer , List<Integer>> graph = new HashMap<>();
    int currentBombs = 0;
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (j != i){
                    if (canDetonate(bombs[i] , bombs[j])){
                        graph.get(i).add(j);
                    }
                }
            }
        }
        int maxBombs = 0;
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            DFS(i , visited);
            maxBombs = Math.max(maxBombs , currentBombs);
            currentBombs = 0;
        }
        return maxBombs;
    }

    private void DFS(int i , boolean[] visited){
        visited[i] = true;
        currentBombs++;
        for (Integer neighbor : graph.get(i)) {
            if (!visited[neighbor]) {
                DFS(neighbor, visited);
            }
        }
    }


    //两个炸弹之间的距离是否小于等于炸弹1的爆炸半径决定了是否可以引爆，而不是两个炸弹半径的和。
    private boolean canDetonate(int[] bomb1 , int[] bomb2){
        long X1 = bomb1[0], Y1 = bomb1[1], R1 = bomb1[2];
        long X2 = bomb2[0], Y2 = bomb2[1];
        long distance = (X2 - X1) * (X2 - X1) + (Y2 - Y1) * (Y2 - Y1);
        long R1Square = R1 * R1;
        return distance <= R1Square;
    }
}
