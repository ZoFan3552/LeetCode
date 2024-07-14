package interview150.Partition;

/**
 * @author: zeddic
 * @description:
 * @date: 2024/7/14 上午11:09
 */
public class ConstructQuadTree_427 {
    public Node construct(int[][] grid) {
        Node root = new Node();
        DFS(grid , root , 0 , 0, grid.length - 1, grid[0].length - 1);
        return root;
    }

    public void DFS(int[][] grid , Node root , int startRow , int startCol , int endRow , int endCol) {
        if (startRow == endRow && startCol == endCol) {
            root.isLeaf = true;
            root.val = grid[startRow][startCol] == 1;
            return;
        }
        boolean allSame =  true;
        int val = grid[startRow][startCol];
        for (int i = startRow ; i <= endRow ; i++) {
            for (int j = startCol ; j <= endCol ; j++) {
                if (grid[i][j] != val) {
                    allSame = false;
                    break;
                }
            }
            if (!allSame) break;
        }
        if (allSame) {
            root.isLeaf = true;
            root.val = val == 1;
        } else {
            root.isLeaf = false;
            root.val = true;
            root.topLeft = new Node();
            root.topRight = new Node();
            root.bottomLeft = new Node();
            root.bottomRight = new Node();
            int rowMid = (endRow + startRow) >> 1;
            int colMid = (endCol + startCol) >> 1;
            DFS(grid , root.topLeft , startRow , startCol , rowMid , colMid);
            DFS(grid , root.topRight , startRow , colMid + 1 , rowMid , endCol);
            DFS(grid , root.bottomLeft , rowMid + 1 , startCol , endRow , colMid);
            DFS(grid , root.bottomRight , rowMid + 1 , colMid + 1 , endRow , endCol);
        }
    }

}
