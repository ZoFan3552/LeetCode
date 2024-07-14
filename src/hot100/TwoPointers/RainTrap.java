package hot100.TwoPointers;

/*
LeetCode 42
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class RainTrap {
    public int trap (int[] height){
        if (height.length < 3){
            return 0;
        }
        int maxCapacity = 0;
        int stay = 0;
        int move = stay + 1;
        int offset = 0;
        while (move < height.length){
            if (move == height.length - 1 && height[stay] >= height[move]){
                int newOffset = 0;
                int newStay = move;
                int newMove = newStay - 1;
                while (newMove >= stay){
                    if (height[newStay] <= height[newMove]){
                        maxCapacity += height[newStay] * (newStay - newMove - 1) - newOffset;
                        newOffset = 0;
                        newStay = newMove--;
                        continue;
                    }
                    newOffset += height[newMove];
                    newMove--;
                }
                break;
            }

            if (height[stay] <= height[move]){
                maxCapacity += height[stay] * (move - stay - 1) - offset;
                offset = 0;
                stay = move++;
                continue;
            }

            offset += height[move];
            move++;
        }


        return maxCapacity;
    }

    public static void main(String[] args) {
        int trap = new RainTrap().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(trap);
    }
}
