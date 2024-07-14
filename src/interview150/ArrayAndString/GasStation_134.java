package interview150.ArrayAndString;

import java.util.*;

public class GasStation_134 {
    List<Integer> res = new ArrayList<>();

    /*
    单次遍历：我们可以通过一次遍历来确定是否有解，并找出可能的起始位置。整个思路基于两个关键的观察：

    如果从加油站 A 出发无法到达加油站 C（即在 B 失败），那么从 A 到 B 之间的任何一个加油站出发都无法到达 C。
    如果总的汽油量减去总的消耗量大于等于0，则必定存在一个解。
    维护两个累加器：totalTank 用来记录整个环路的总净汽油量（加油总量 - 消耗总量），currTank 用于记录当前起点开始的净汽油量。如果在某个点 currTank 变为负数，表示从当前起点无法继续前进，需要更换起点。

    更换起点：如果在加油站 i 无法前往 i+1（因为 currTank 为负），则需要从 i+1 开始尝试，同时重置 currTank。


     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalTank = 0;
        int currTank = 0;
        int startingStation = 0;

        for (int i = 0; i < n; i++) {
            totalTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];
            // 如果不能到达下一个站点
            if (currTank < 0) {
                // 从下一个站点开始重新计算
                startingStation = i + 1;
                currTank = 0;
            }
        }
        // 检查总油量是否足以完成整个环行
        return totalTank >= 0 ? startingStation : -1;
    }


    public static void main(String[] args) {
        int res = new GasStation_134().canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
        System.out.println(res);
    }

}
