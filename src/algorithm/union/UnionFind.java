package algorithm.union;

/**
 * @author: zeddic
 * @description: 并查集
 * @date: 2024/8/4 下午2:30
 */
public class UnionFind {
    private final int[] parent;
    private final int[] rank;

    public UnionFind(int size) {
        this.parent = new int[size];
        this.rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    //压缩路径
    public int find(int x){
        if (parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if (rank[rootX] > rank[rootY]){//x 的 rank 比 y 的大，则 x 作为 y 的祖先
            parent[rootY] = rootX;
        }else if (rank[rootX] < rank[rootY]){//x 的 rank 比 y 的小，则 y 作为 x 的祖先
            parent[rootX] = rootY;
        }else {
            parent[rootY] = rootX;////x 的 rank 与 y 的相等，则 x 作为 y 的祖先，且 x 的 rank 加一
            rank[rootX]++;
        }
    }

    public boolean connected(int x, int y){
        return find(x) == find(y);
    }
}
