package algorithm.union;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/8/24 下午5:00
 */
public class RedundantConnectionII_685 {
    static class UnionFind{
        int[] parent;
        int[] rank;

        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = 0;
            }
        }

        public int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY){
                if(rank[rootX] > rank[rootY]){
                    parent[rootY] = rootX;
                    return true;
                }else if(rank[rootX] < rank[rootY]){
                    parent[rootX] = rootY;
                    return true;
                }else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                    return true;
                }
            }
            return false;
        }
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        UnionFind unionFind = new UnionFind(n);
        int[] res = new int[2];
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if(!unionFind.union(x - 1, y - 1)){
                res = new int[]{x , y};
            }
        }
        return res;
    }
}
